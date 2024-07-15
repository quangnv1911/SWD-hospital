package com.henrygphp.swd392hospitalsystem.DTO.Req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddAppointmentReq {
    private Integer patientId;
    private Integer doctorId;
    private Integer receptionistId;
    private String appointmentDate;
    private String appointmentStartTime;
    private String appointmentEndTime;
    private String reason;
    private String status;

}
