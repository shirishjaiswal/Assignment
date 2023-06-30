package com.geekster.hospitalAPI.dao;

import com.geekster.hospitalAPI.model.DoctorEntity;
import com.geekster.hospitalAPI.model.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientDao extends JpaRepository<PatientEntity,Integer> {

    @Query(value = "select * from patient_entity where status_status_id=1 and id= :id",nativeQuery = true)
    List<PatientEntity> findPatientById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update patient_entity set status_status_id=2 where id= :id",
            countQuery = "Select count(*) from patient_entity",nativeQuery = true)
    void deletePatientById(Integer id);
}
