package com.henrygphp.swd392hospitalsystem.DTO.Resp;

import com.henrygphp.swd392hospitalsystem.DTO.All.PatientDTO;
import com.henrygphp.swd392hospitalsystem.DTO.All.PatientHistoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient_HistoryInfoRespDTO {
    private PatientDTO patientDTO;
    private PatientHistoryDTO patientHistoryDTO;
}
