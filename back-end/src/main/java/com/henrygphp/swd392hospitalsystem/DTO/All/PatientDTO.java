package com.henrygphp.swd392hospitalsystem.DTO.All;

import com.henrygphp.swd392hospitalsystem.Models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String dob;
    private Gender gender;
}
