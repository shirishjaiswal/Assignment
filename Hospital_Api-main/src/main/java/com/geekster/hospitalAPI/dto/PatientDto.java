package com.geekster.hospitalAPI.dto;


import com.geekster.hospitalAPI.model.Symptom;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PatientDto {
    private String name;
    private String city;
    private String email;
    private String phone_number;
    private String symptom;
}
