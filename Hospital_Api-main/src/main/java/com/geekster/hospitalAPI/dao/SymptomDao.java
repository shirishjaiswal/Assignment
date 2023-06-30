package com.geekster.hospitalAPI.dao;

import com.geekster.hospitalAPI.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymptomDao extends JpaRepository<Symptom,Integer> {
    List<Symptom> findBySymptomName(String symptomName);
}
