package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import com.henrygphp.swd392hospitalsystem.Repositories.AppointmentRepo;
import com.henrygphp.swd392hospitalsystem.Services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public Optional<Appointment> getAppointmentById(Integer id) {
        return appointmentRepo.findById(id);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Integer patientId) {
        return appointmentRepo.findAppointmentsByPatient_PatientId(patientId);
    }

    @Override
    public Optional<Appointment> updateAppointment(Appointment appointment) {
        appointmentRepo.save(appointment);
        return appointmentRepo.findById(appointment.getAppointmentId());
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepo.delete(appointment);
    }

    @Override
    public void deleteAppointmentById(Integer id) {
        appointmentRepo.deleteById(id);
    }
}
