package com.henrygphp.swd392hospitalsystem.Services;

import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService{
    Appointment addAppointment(Appointment appointment);
    Optional<Appointment> getAppointmentById(Integer id);

    List<Appointment> getAppointmentsByPatientId(Integer patientId);

    Optional<Appointment> updateAppointment(Appointment appointment);
    void deleteAppointment(Appointment appointment);
    void deleteAppointmentById(Integer id);
}
