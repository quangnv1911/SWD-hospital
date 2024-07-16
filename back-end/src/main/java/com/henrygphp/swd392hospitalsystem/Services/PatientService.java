package com.henrygphp.swd392hospitalsystem.Services;

import com.henrygphp.swd392hospitalsystem.DTO.All.PatientDTO;
import com.henrygphp.swd392hospitalsystem.Models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {
    //get Patient Info by ID
    Optional<Patient> getPatientById(Long id);
    //add Patient
    Patient addPatient(Patient newPatient);
    //update Patient
    Patient updatePatient(Patient patient);
    //delete Patient
    void deletePatient(Patient patient);
    //delete Patient by id
    void deletePatientById(Long id);
    //get all Patients
    List<Patient> getAllPatients();

    PatientDTO convertToDTO(Patient patient);

    Patient convertToEntity(PatientDTO patientDTO);
}
