package com.assignment.JobSearchPortal.repository;

import com.assignment.JobSearchPortal.model.Job;

import com.assignment.JobSearchPortal.model.JobCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

    //Custom Finders
    public Iterable<Job> findByCompanyName(String companyName);
    public List<Job> findByJobType(JobCategory categoryType);
    public boolean existsByCompanyName (String companyName);
    public Iterable<Job> findByOrderBySalary();

    //Custom Query's

    //Updating name of the Job of id
    @Modifying
    @Transactional
    @Query(value = "update job set title = :title where id = :id", nativeQuery = true)
    public int updateJobSetTitleForId(@Param("title")String title, @Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value = "update job set salary = :salary where id = :id", nativeQuery = true)
    public int updateJobSetSalaryForId(@Param("salary")Double salary, @Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value = "Delete from job where company_name = :companyName", nativeQuery = true)
    void deleteJobByCompanyName(@Param("companyName") String companyName);
}
