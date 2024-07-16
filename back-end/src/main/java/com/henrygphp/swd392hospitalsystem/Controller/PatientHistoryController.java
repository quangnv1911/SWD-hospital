package com.henrygphp.swd392hospitalsystem.Controller;

import com.henrygphp.swd392hospitalsystem.DTO.All.PatientHistoryDTO;
import com.henrygphp.swd392hospitalsystem.Services.PatientHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient-history")
@RequiredArgsConstructor
public class PatientHistoryController {
    private final PatientHistoryService patientHistoryService;
    //Get patient history list by patient id;
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<PatientHistoryDTO>> getPatientHistoryByPatientId(@PathVariable Long patientId) {
        var patientHistoryList = patientHistoryService.getPatientHistoryListByPatientId(patientId);
        if(patientHistoryList.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(patientHistoryService.convertToDTOList(patientHistoryList));
    }
}
