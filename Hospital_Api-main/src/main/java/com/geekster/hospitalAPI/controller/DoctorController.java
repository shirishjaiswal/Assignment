package com.geekster.hospitalAPI.controller;

import com.geekster.hospitalAPI.dao.SpecialityDao;
import com.geekster.hospitalAPI.dao.StatusDao;
import com.geekster.hospitalAPI.dto.DoctorDto;
import com.geekster.hospitalAPI.model.DoctorEntity;
import com.geekster.hospitalAPI.model.Speciality;
import com.geekster.hospitalAPI.model.Status;
import com.geekster.hospitalAPI.service.DoctorService;
import com.geekster.hospitalAPI.utils.CommonUtils;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    StatusDao statusDao;

    @Autowired
    SpecialityDao specialityDao;

    @Autowired
    CommonUtils commonUtils;

    @PostMapping(value = "/addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorDto doctorDto){
        JSONObject requestJson = new JSONObject(doctorDto);
        JSONObject errorList = commonUtils.validateJsonDoctor(requestJson);
        if(!errorList.isEmpty()){
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }else{
            DoctorEntity doctor = setDoctor(requestJson);
            int id = doctorService.saveDoctor(doctor);
            return new ResponseEntity<>("Dr. "+doctor.getName() +" saved with id - "+id,HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/deleteDoctorById/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String id){
        ResponseEntity<String> response = doctorService.deleteById(Integer.valueOf(id));
        return response;
    }

    @GetMapping("/getDoctor")
    public ResponseEntity<String> getDoctor(@Nullable @RequestParam Integer doctorId){
        List<DoctorEntity> doctorEntities = doctorService.getDoctor(doctorId);
        JSONArray jsonArray = new JSONArray();
        for (DoctorEntity doctor:doctorEntities){
            JSONObject jsonObject = commonUtils.setJson(doctor);
            jsonArray.put(jsonObject);
        }
        return new ResponseEntity<>(jsonArray.toString(),HttpStatus.OK);
    }

    private DoctorEntity setDoctor(JSONObject requestJson) {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setName(requestJson.getString("name"));
        doctor.setCity(requestJson.getString("city"));
        doctor.setEmail(requestJson.getString("email"));
        doctor.setPhoneNumber(requestJson.getString("phone_number"));
        Status status = statusDao.findById(1).get();
        doctor.setStatus(status);
        Speciality speciality = specialityDao.findBySpecialityName(requestJson.getString("speciality"));
        doctor.setSpeciality(speciality);
        return doctor;
    }
}
