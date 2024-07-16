package com.henrygphp.swd392hospitalsystem.DTO.Req;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorReqDTO {
    //dd/MM/yyyy
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$")
    private String date;
    //HH:mm
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    private String startTime;
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    private String endTime;
}
