package com.henrygphp.swd392hospitalsystem.DTO.Resp;

import com.henrygphp.swd392hospitalsystem.DTO.AppointmentInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentUpdateRespDTO {
    private String status;
    private AppointmentInfoDTO appointment;
}
