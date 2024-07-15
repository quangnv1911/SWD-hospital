package com.henrygphp.swd392hospitalsystem.DTO.All;

import com.henrygphp.swd392hospitalsystem.Models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    private String date;
    private String startTime;
    private String endTime;
    private Status status;
    private String reason;
    private DoctorDTO doctorInfo;
    private PatientDTO patientInfo;
    private ReceptionistDTO receptionistInfo;
}
