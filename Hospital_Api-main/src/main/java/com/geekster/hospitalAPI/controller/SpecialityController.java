package com.geekster.hospitalAPI.controller;

import com.geekster.hospitalAPI.model.Speciality;
import com.geekster.hospitalAPI.service.SpecialityService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/speciality")
public class SpecialityController {

    @Autowired
    SpecialityService specialityService;

    @PostMapping("/addSpeciality")
    public ResponseEntity<String> addSpeciality(@RequestBody String speciality){
        JSONObject jsonObject = new JSONObject(speciality);
        Speciality specialityObj = new Speciality();
        specialityObj.setSpecialityName(jsonObject.getString("speciality"));
        int id = specialityService.saveSpeciality(specialityObj);
        return new ResponseEntity<>("Speciality saved with id - "+id, HttpStatus.CREATED);
    }


}
