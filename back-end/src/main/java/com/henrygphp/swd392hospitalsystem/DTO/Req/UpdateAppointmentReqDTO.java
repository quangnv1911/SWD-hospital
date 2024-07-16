package com.henrygphp.swd392hospitalsystem.DTO.Req;

import com.henrygphp.swd392hospitalsystem.Models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppointmentReqDTO {
    private Long id;
    private String date;
    private String startTime;
    private String endTime;
    private Status status;
    private String reason;
    private Long doctorId;
    private Long patientId;
    private Long receptionistId;
}
