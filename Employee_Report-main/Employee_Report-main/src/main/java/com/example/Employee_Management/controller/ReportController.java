package com.example.Employee_Management.controller;

import com.example.Employee_Management.model.Report;
import com.example.Employee_Management.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;


    @PostMapping("/add")
    public ResponseEntity<String> addReport(@RequestBody Report report) {
        return reportService.addReport(report);
    }
}

