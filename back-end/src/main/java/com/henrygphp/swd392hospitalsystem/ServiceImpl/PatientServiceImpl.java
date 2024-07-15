package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.DTO.All.PatientDTO;
import com.henrygphp.swd392hospitalsystem.Models.Patient;
import com.henrygphp.swd392hospitalsystem.Repositories.PatientRepo;
import com.henrygphp.swd392hospitalsystem.Services.PatientService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepo.findById(id);
    }

    @Override
    public Patient addPatient(Patient newPatient) {
        return patientRepo.save(newPatient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepo.delete(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepo.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public PatientDTO convertToDTO(Patient patient) {
        return new PatientDTO(patient.getPatientId(), patient.getFirstName(), patient.getLastName(), patient.getPhoneNumber(), patient.getEmail(), patient.getAddress(), patient.getDob().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), patient.getGender());
    }

    @Override
    public Patient convertToEntity(PatientDTO patientDTO) {
        return new Patient(patientDTO.getPatientId(), patientDTO.getFirstName(), patientDTO.getLastName(), patientDTO.getPhoneNumber(), patientDTO.getEmail(), patientDTO.getAddress(), LocalDate.parse(patientDTO.getDob(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), patientDTO.getGender());
    }
}
