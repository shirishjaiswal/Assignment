package com.geekster.hospitalAPI.controller;

import com.geekster.hospitalAPI.dao.StatusDao;
import com.geekster.hospitalAPI.dao.SymptomDao;
import com.geekster.hospitalAPI.dto.DoctorDto;
import com.geekster.hospitalAPI.dto.PatientDto;
import com.geekster.hospitalAPI.model.*;
import com.geekster.hospitalAPI.service.PatientService;
import com.geekster.hospitalAPI.utils.CommonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    StatusDao statusDao;

    @Autowired
    SymptomDao symptomDao;

    @PostMapping(value = "/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody PatientDto patientDto){
        JSONObject requestJson = new JSONObject(patientDto);
        JSONObject errorList = validateJsonPatient(requestJson);
        if(!errorList.isEmpty()){
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }else{
            PatientEntity patient = setPatient(requestJson);
            int id = patientService.savePatient(patient);
            return new ResponseEntity<>("Patient "+patient.getName() +" is saved with id - "+id,HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/deletePatientById/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable String id){
        ResponseEntity<String> response = patientService.deleteById(Integer.valueOf(id));
        return response;
    }

    @GetMapping(value = "/suggest-doctor/{patientId}")
    public ResponseEntity<String> suggestDoctor(@PathVariable Integer patientId){
        ResponseEntity<String> response = patientService.suggestDoctor(patientId);
        return response;
    }

    private PatientEntity setPatient(JSONObject requestJson) {
        PatientEntity patient = new PatientEntity();
        patient.setName(requestJson.getString("name"));
        patient.setCity(requestJson.getString("city"));
        patient.setEmail(requestJson.getString("email"));
        patient.setPhoneNumber(requestJson.getString("phone_number"));
        Status status = statusDao.findById(1).get();
        patient.setStatus(status);
        Symptom symptom = symptomDao.findBySymptomName(requestJson.getString("symptom")).get(0);
        patient.setSymptom(symptom);
        return patient;
    }

    private JSONObject validateJsonPatient(JSONObject requestJson) {
        JSONObject errorList = new JSONObject();

        if(requestJson.has("name")) {
            if(!CommonUtils.validateName(requestJson.getString("name"))){
                errorList.put("Invalid parameter","Min 3 characters should be there in name Eg: Rahul");
            }
        } else{
            errorList.put("Missing field","name");
        }

        if(requestJson.has("email")){
            if(!CommonUtils.isValidEmail(requestJson.getString("email"))){
                errorList.put("Invalid parameter","emailId");
            }
        }else{
            errorList.put("Missing field","email");
        }

        if(requestJson.has("phone_number")){
            if (!CommonUtils.isValidPhoneNumber(requestJson.getString("phone_number"))){
                errorList.put("Invalid parameter","phone_number");
            }
        }else{
            errorList.put("Missing field","phone_number");
        }

        if(requestJson.has("city")){
            String city = requestJson.getString("city");
            if(!CommonUtils.validateCity(city)) {
                errorList.put("Invalid parameter","City name should contain 3-20 characters");
            }
        }else{
            errorList.put("Missing Field","city");
        }

        if(requestJson.has("symptom")){
            if(symptomDao.findBySymptomName(requestJson.getString("symptom")).isEmpty()){
                errorList.put("Symptom not found in database","Add first in database");
            }
        }else{
            errorList.put("Missing field","symptom");
        }

        return errorList;
    }
}
