package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.DTO.All.DoctorDTO;
import com.henrygphp.swd392hospitalsystem.DTO.All.PatientDTO;
import com.henrygphp.swd392hospitalsystem.DTO.All.PatientHistoryDTO;
import com.henrygphp.swd392hospitalsystem.DTO.Resp.Patient_HistoryInfoRespDTO;
import com.henrygphp.swd392hospitalsystem.Models.PatientHistory;
import com.henrygphp.swd392hospitalsystem.Repositories.PatientHistoryRepo;
import com.henrygphp.swd392hospitalsystem.Services.PatientHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientHistoryServiceImpl implements PatientHistoryService {
    private final PatientHistoryRepo patientHistoryRepo;

    public List<PatientHistory> getPatientHistoryListByPatientId(Long patientId) {
        return patientHistoryRepo.findAllByPatient_PatientId(patientId);
    }

    public PatientHistoryDTO convertToDTO(PatientHistory patientHistory) {
        return new PatientHistoryDTO(
                patientHistory.getPatientHistoryId(),
                patientHistory.getVisitDate(),
                patientHistory.getDiagnosis(),
                patientHistory.getDescription(),
                patientHistory.getPrescription(),
                patientHistory.getNotes(),
                new PatientDTO(
                        patientHistory.getPatient().getPatientId(),
                        patientHistory.getPatient().getFirstName(),
                        patientHistory.getPatient().getLastName(),
                        patientHistory.getPatient().getPhoneNumber(),
                        patientHistory.getPatient().getEmail(),
                        patientHistory.getPatient().getAddress(),
                        patientHistory.getPatient().getDob().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        patientHistory.getPatient().getGender()
                ),
                new DoctorDTO(
                        patientHistory.getDoctor().getDoctorId(),
                        patientHistory.getDoctor().getFirstName(),
                        patientHistory.getDoctor().getLastName(),
                        patientHistory.getDoctor().getSpeciality(),
                        patientHistory.getDoctor().getPhoneNumber(),
                        patientHistory.getDoctor().getEmail()
                )
        );
    }

    public List<PatientHistoryDTO> convertToDTOList(List<PatientHistory> patientHistories) {
        return patientHistories.stream().map(this::convertToDTO).toList();
    }
}
