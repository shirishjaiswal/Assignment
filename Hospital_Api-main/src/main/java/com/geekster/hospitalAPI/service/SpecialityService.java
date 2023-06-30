package com.geekster.hospitalAPI.service;

import com.geekster.hospitalAPI.dao.SpecialityDao;
import com.geekster.hospitalAPI.model.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {

    @Autowired
    SpecialityDao specialityDao;

    public int saveSpeciality(Speciality specialityObj) {
        return specialityDao.save(specialityObj).getId();
    }
}
