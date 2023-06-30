package com.geekster.hospitalAPI.dao;

import com.geekster.hospitalAPI.model.DoctorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorDao extends JpaRepository<DoctorEntity,Integer> {

    @Query(value = "select * from doctor_entity where status_id=1 and id= :id",nativeQuery = true)
    List<DoctorEntity> findDoctorById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update doctor_entity set status_id=2 where id= :id",
            countQuery = "Select count(*) from doctor_entity",nativeQuery = true)
    void deleteDoctorById(Integer id);

    @Query(value = "select * from doctor_entity where status_id=1 and city= :city_name",nativeQuery = true)
    List<DoctorEntity> findDoctorByCity(String city_name);

    @Query(value = "select * from doctor_entity where status_id=1 and city= :city and speciality_id = :id",nativeQuery = true)
    List<DoctorEntity> findByCityAndSpeciality(String city,int id);

}
