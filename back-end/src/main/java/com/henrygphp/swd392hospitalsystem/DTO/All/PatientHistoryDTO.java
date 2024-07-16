package com.henrygphp.swd392hospitalsystem.DTO.All;

import com.henrygphp.swd392hospitalsystem.Models.Doctor;
import com.henrygphp.swd392hospitalsystem.Models.Patient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientHistoryDTO {
    private Long patientHistoryId;

    private LocalDate visitDate;

    private String diagnosis;

    private String description;

    private String prescription;

    private String notes;

    private PatientDTO patientInfo;

    private DoctorDTO doctorInfo;
}
