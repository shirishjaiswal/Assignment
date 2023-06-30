package com.geekster.hospitalAPI.dao;

import com.geekster.hospitalAPI.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityDao extends JpaRepository<Speciality,Integer> {

    Speciality findBySpecialityName(String speciality);
}
