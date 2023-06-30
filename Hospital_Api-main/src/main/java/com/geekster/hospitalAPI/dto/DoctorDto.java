package com.geekster.hospitalAPI.dto;

import lombok.Data;

@Data
public class DoctorDto {
    private String name;
    private String city;
    private String email;
    private String phone_number;
    private String speciality;
}
