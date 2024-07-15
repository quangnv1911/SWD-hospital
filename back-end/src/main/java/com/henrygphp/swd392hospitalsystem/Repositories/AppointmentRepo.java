package com.henrygphp.swd392hospitalsystem.Repositories;

import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import com.henrygphp.swd392hospitalsystem.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentsByPatient_PatientId(Long patientId);
    List<Appointment> findByStatus(Status status);
}
