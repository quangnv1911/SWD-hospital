package com.henrygphp.swd392hospitalsystem.Services;

import com.henrygphp.swd392hospitalsystem.DTO.All.DoctorDTO;
import com.henrygphp.swd392hospitalsystem.Models.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    //get Doctor Info by ID
    Optional<Doctor> getDoctorById(Long id);
    //add Doctor
    Doctor addDoctor(Doctor newDoctor);
    //update Doctor
    Doctor updateDoctor(Doctor doctor);
    //delete Doctor
    void deleteDoctor(Doctor doctor);
    //delete Doctor by id
    void deleteDoctorById(Long id);
    //get all Doctors
    List<Doctor> getAllDoctors();

    DoctorDTO convertToDTO(Doctor doctor);

    List<Doctor> getAllAvailableDoctors(LocalDate date, LocalTime startTime, LocalTime endTime);
}
