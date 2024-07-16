package com.henrygphp.swd392hospitalsystem.DTO.All;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String speciality;
    private String phoneNumber;
    private String email;

//    public DoctorDTO(Long doctorId){
//        this.doctorId = doctorId;
//    }
}
