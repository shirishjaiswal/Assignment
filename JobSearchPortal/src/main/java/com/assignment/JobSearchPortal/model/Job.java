package com.assignment.JobSearchPortal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Job {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @Length(min = 5, max = 50, message = "Length of the title should be between 5 and 20")
    private String title;
    @Length(max = 400, message = "Job description can be upto 400 characters")
    private String description;
    @Column(nullable = false)
    private String location;
    private Double salary;
    @Column(nullable = false)
    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobCategory jobType;
}
