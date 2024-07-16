package com.henrygphp.swd392hospitalsystem.Services;

import com.henrygphp.swd392hospitalsystem.DTO.All.PatientHistoryDTO;
import com.henrygphp.swd392hospitalsystem.Models.Patient;
import com.henrygphp.swd392hospitalsystem.Models.PatientHistory;
import com.henrygphp.swd392hospitalsystem.Repositories.PatientHistoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientHistoryService {
    List<PatientHistory> getPatientHistoryListByPatientId(Long patientId);

    PatientHistoryDTO convertToDTO(PatientHistory patientHistory);

    List<PatientHistoryDTO> convertToDTOList(List<PatientHistory> patientHistories);
}
