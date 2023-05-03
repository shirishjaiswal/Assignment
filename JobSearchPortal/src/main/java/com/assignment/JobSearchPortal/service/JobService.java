package com.assignment.JobSearchPortal.service;

import com.assignment.JobSearchPortal.model.Job;
import com.assignment.JobSearchPortal.model.JobCategory;
import com.assignment.JobSearchPortal.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepo;
    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Optional<Job> getJobById(String id) {
        return jobRepo.findById(Integer.parseInt(id));
    }

    public Iterable<Job> getJobsByCompanyName(String companyName) {
        return jobRepo.findByCompanyName(companyName);
    }

    public List<Job> getJobsByCategory(String name) {
        String jCategory = name.toUpperCase();
        return jobRepo.findByJobType(JobCategory.valueOf(jCategory));
    }

    public Iterable<Job> orderBySalary() {
        return jobRepo.findByOrderBySalary();
    }

    public String addJobs(Iterable<Job> jobs) {
        List<Job> save = jobRepo.saveAll(jobs);
        return "Jobs Saved";
    }

    public String addJob(Job job) {
        Job save = jobRepo.save(job);
        return "Job Saved";
    }

    public String deleteJobById(String id) {
        jobRepo.deleteById(Integer.parseInt(id));
        if(!jobRepo.existsById(Integer.parseInt(id))) {
            return "Job with id " + id + " has been Deleted";
        }
        return "Job with id " + id + " has not been Deleted";
    }

    public String deleteJobByCompanyName(String companyName) {
        jobRepo.deleteJobByCompanyName(companyName);
        if(!jobRepo.existsByCompanyName(companyName)) {
            return "All Jobs from Company " + companyName + " has been Deleted";
        }
        return "All Jobs from Company " + companyName + " has not been Deleted";
    }

    public Optional<Job> updateTitleById(String title, String id) {
        Integer noOfRowsUpdated = jobRepo.updateJobSetTitleForId(title, Integer.parseInt(id));
        return jobRepo.findById(Integer.parseInt(id));
    }

    public Optional<Job> updateSalaryById(String salary, String id) {
        Integer noOfRowsUpdated = jobRepo.updateJobSetSalaryForId(Double.parseDouble(salary), Integer.parseInt(id));
        return jobRepo.findById(Integer.parseInt(id));
    }
}
