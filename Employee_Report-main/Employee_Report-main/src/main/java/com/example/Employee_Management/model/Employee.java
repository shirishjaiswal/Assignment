package com.example.Employee_Management.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope =Employee.class,property = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @Column(unique = true,nullable = false,name = "Email")
    private String email;

    @NotNull
    @Digits(integer = 10,fraction = 0)
    @Length(min=10,message = "Length must be 10 digits")
    @Column(unique = true,nullable = false,name = "Contact_No")
    private String phoneNumber;

    @NotBlank
    private String jobRole;

    @NotNull
    private double salary;

    @OneToMany(mappedBy = "employee")
    private List<Report> reports;

}
