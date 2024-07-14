package com.henrygphp.swd392hospitalsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentInfoDTO {
    private Integer id;
    private String date;
    private String time;
    private String status;
    private String reason;
    private Integer patientId;
    private Integer doctorId;
}
