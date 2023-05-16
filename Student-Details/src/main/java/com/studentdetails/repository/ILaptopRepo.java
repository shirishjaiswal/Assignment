package com.studentdetails.repository;

import com.studentdetails.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILaptopRepo extends JpaRepository<Laptop, Integer> {
    @Query(nativeQuery = true, value = "Select * from laptop where student_id = :id")
    List<Laptop> findByStudentId(@Param("id") Integer id);
}
