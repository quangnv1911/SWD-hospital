package com.henrygphp.swd392hospitalsystem.Controller;

import com.henrygphp.swd392hospitalsystem.DTO.All.DoctorDTO;
import com.henrygphp.swd392hospitalsystem.DTO.Req.DoctorReqDTO;
import com.henrygphp.swd392hospitalsystem.Models.Doctor;
import com.henrygphp.swd392hospitalsystem.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/all")
    //get all doctor list
    public ResponseEntity<?> getAllDoctors() {
        List<Doctor> doctor = doctorService.getAllDoctors();

        //Convert to doctorDTO
        List<DoctorDTO> result = new ArrayList<>();

        doctor.forEach(d -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDoctorId(d.getDoctorId());
            doctorDTO.setFirstName(d.getFirstName());
            doctorDTO.setLastName(d.getLastName());
            doctorDTO.setSpeciality(d.getSpeciality());
            doctorDTO.setPhoneNumber(d.getPhoneNumber());
            doctorDTO.setEmail(d.getEmail());
            result.add(doctorDTO);
        });


        return ResponseEntity.ok(result);
    }

    @GetMapping("/all/available")
    //get all available doctors
    public ResponseEntity<?> getAllAvailableDoctors(@RequestBody DoctorReqDTO doctorReqDTO) {
        //Convert to LocalTime and LocalDate
        LocalDate appointmentDate = LocalDate.parse(doctorReqDTO.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime startTime = LocalTime.parse(doctorReqDTO.getStartTime(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse(doctorReqDTO.getEndTime(), DateTimeFormatter.ofPattern("HH:mm"));

        List<Doctor> doctor = doctorService.getAllAvailableDoctors(appointmentDate, startTime, endTime);

        //Convert to doctorDTO
        List<DoctorDTO> result = new ArrayList<>();

        doctor.forEach(d -> {
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDoctorId(d.getDoctorId());
            doctorDTO.setFirstName(d.getFirstName());
            doctorDTO.setLastName(d.getLastName());
            doctorDTO.setSpeciality(d.getSpeciality());
            doctorDTO.setPhoneNumber(d.getPhoneNumber());
            doctorDTO.setEmail(d.getEmail());
            result.add(doctorDTO);
        });


        return ResponseEntity.ok(result);
    }
}
