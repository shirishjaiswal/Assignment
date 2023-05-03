package com.assignment.JobSearchPortal.controller;

import com.assignment.JobSearchPortal.model.Job;
import com.assignment.JobSearchPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(value = "/all")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping(value = "/byId/{id}")
    public Optional<Job> getJobById (@PathVariable String id) {
        return jobService.getJobById(id);
    }

    @GetMapping(value = "/byCompanyName/{companyName}")
    public Iterable<Job> getJobByName(@PathVariable String companyName) {
        return jobService.getJobsByCompanyName(companyName);
    }

    @GetMapping(value = "/orderBySalary/asc")
    public Iterable<Job> orderBySalary() {
        return jobService.orderBySalary();
    }

    //TODO check?
    @GetMapping(value = "/byCategory/{category}")
    public List<Job> getJobByCategory(@PathVariable String category) {
        return jobService.getJobsByCategory(category);
    }
    @PostMapping(value = "/inserts")
    public String addJobList (@RequestBody Iterable<Job> jobs) {
        return jobService.addJobs(jobs);
    }

    @PostMapping(value = "/insert")
    public String addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @DeleteMapping(value = "/byId/{id}")
    public String deleteJobById (@PathVariable String id) {
        return jobService.deleteJobById(id);
    }

    @DeleteMapping(value = "/byName/{companyName}")
    public String deleteJobByName(@PathVariable String companyName) {
        return jobService.deleteJobByCompanyName(companyName);
    }

    @PutMapping(value = "/update/{id}/title/{title}")
    public Optional<Job> updateJobTitleForId(@PathVariable String id, @PathVariable String title ) {
        return jobService.updateTitleById(title, id);
    }

    @PutMapping(value = "/update/{id}/salary/{salary}")
    public Optional<Job> updateJobSalaryForId(@PathVariable String id, @PathVariable String salary) {
        return jobService.updateSalaryById(salary, id);
    }
}
