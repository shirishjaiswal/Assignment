package com.geekster.hospitalAPI.service;

import com.geekster.hospitalAPI.dao.DoctorDao;
import com.geekster.hospitalAPI.dao.PatientDao;
import com.geekster.hospitalAPI.model.DoctorEntity;
import com.geekster.hospitalAPI.model.PatientEntity;
import com.geekster.hospitalAPI.model.Speciality;
import com.geekster.hospitalAPI.model.Symptom;
import com.geekster.hospitalAPI.utils.CommonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientDao patientDao;

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    CommonUtils commonUtils;

    public int savePatient(PatientEntity patient) {
        return patientDao.save(patient).getId();
    }

    public ResponseEntity<String> deleteById(Integer id) {
        if(!patientDao.findPatientById(id).isEmpty()){
            patientDao.deletePatientById(id);
            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid patient_id",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> suggestDoctor(Integer patientId) {
        PatientEntity patient = patientDao.findPatientById(patientId).get(0);
        Symptom symptom = patient.getSymptom();
        Speciality speciality = symptom.getSpeciality();
        String city = patient.getCity();
        int id = speciality.getId();
        if(doctorDao.findDoctorByCity(city).isEmpty()){
            return new ResponseEntity<>("We are still waiting to expand to your location",HttpStatus.NOT_FOUND);
        }else{
            if(doctorDao.findByCityAndSpeciality(city,id).isEmpty()){
                return new ResponseEntity<>("There isn’t any doctor present at your location for your symptom",HttpStatus.NOT_FOUND);
            }else {
                List<DoctorEntity> doctorEntityList = doctorDao.findByCityAndSpeciality(city,id);
                JSONArray jsonArray = new JSONArray();
                for(DoctorEntity doctor:doctorEntityList){
                    JSONObject jsonObject = commonUtils.setJson(doctor);
                    jsonArray.put(jsonObject);
                }
                return new ResponseEntity<>(jsonArray.toString(),HttpStatus.FOUND);
            }
        }
    }


}
