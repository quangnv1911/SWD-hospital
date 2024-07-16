package com.henrygphp.swd392hospitalsystem.Controller;

import com.henrygphp.swd392hospitalsystem.DTO.All.PatientDTO;
import com.henrygphp.swd392hospitalsystem.Models.Patient;
import com.henrygphp.swd392hospitalsystem.Services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    //Get patient info by id
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
//        return patient.map(value -> new ResponseEntity<>(new PatientInfoDTO(value.getPatientId(), value.getFirstName(),
//                value.getLastName(), value.getPhoneNumber(), value.getEmail(), value.getAddress(), value.getDob(), value.getGender()), ResponseEntity.OK));
        return ResponseEntity.ok(new PatientDTO(patient.get().getPatientId(), patient.get().getFirstName(),
                patient.get().getLastName(), patient.get().getPhoneNumber(), patient.get().getEmail(), patient.get().getAddress(), patient.get().getDob().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), patient.get().getGender()));
    }

    //Get all patients
    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

}
