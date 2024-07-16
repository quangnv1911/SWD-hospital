package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.DTO.All.DoctorDTO;
import com.henrygphp.swd392hospitalsystem.Models.Doctor;
import com.henrygphp.swd392hospitalsystem.Repositories.DoctorRepo;
import com.henrygphp.swd392hospitalsystem.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;

    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepo.findById(id);
    }

    @Override
    public Doctor addDoctor(Doctor newDoctor) {
        return doctorRepo.save(newDoctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorRepo.delete(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepo.deleteById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public DoctorDTO convertToDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getSpeciality());
    }

    @Override
    public List<Doctor> getAllAvailableDoctors(LocalDate date, LocalTime startTime, LocalTime endTime) {
        return doctorRepo.findAllAvailableDoctors(date, startTime, endTime);
    }
}
