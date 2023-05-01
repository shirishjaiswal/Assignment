package com.assignment.UniversityEventManagement.repository;

import com.assignment.UniversityEventManagement.model.Department;
import com.assignment.UniversityEventManagement.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {

    @Modifying
    @Transactional
    @Query(value = "Update student set department = :dtp where id = :id", nativeQuery = true)
    int updateStudentSetDepartmentForId(@Param("dtp")String dtp, @Param("id") Integer id);
}
