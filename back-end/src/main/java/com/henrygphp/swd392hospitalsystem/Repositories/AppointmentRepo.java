package com.henrygphp.swd392hospitalsystem.Repositories;

import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    List<Appointment> findAppointmentsByPatient_PatientId(Integer patientId);
}
