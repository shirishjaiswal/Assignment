package com.geekster.hospitalAPI.service;

import com.geekster.hospitalAPI.dao.DoctorDao;
import com.geekster.hospitalAPI.model.DoctorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorDao doctorDao;


    public int saveDoctor(DoctorEntity doctor) {
        return doctorDao.save(doctor).getId();
    }

    public ResponseEntity<String> deleteById(Integer id) {
        if(!doctorDao.findDoctorById(id).isEmpty()){
            doctorDao.deleteDoctorById(id);
            return new ResponseEntity<>("Doctor deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid doctor_id",HttpStatus.BAD_REQUEST);
    }


    public List<DoctorEntity> getDoctor(Integer doctorId) {
        List<DoctorEntity> doctorEntities;
        if(doctorId!=null){
            doctorEntities = doctorDao.findDoctorById(doctorId);
            return doctorEntities;
        }
        doctorEntities = doctorDao.findAll();
        return doctorEntities;
    }
}
