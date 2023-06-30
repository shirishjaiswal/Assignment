package com.geekster.hospitalAPI.service;

import com.geekster.hospitalAPI.dao.SymptomDao;
import com.geekster.hospitalAPI.model.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomService {

    @Autowired
    SymptomDao symptomDao;

    public int addSymptom(Symptom symptom) {
        return symptomDao.save(symptom).getId();
    }
}
