package com.henrygphp.swd392hospitalsystem.Services;

import com.henrygphp.swd392hospitalsystem.DTO.All.AppointmentDTO;
import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import com.henrygphp.swd392hospitalsystem.Models.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService{
    Appointment addAppointment(Appointment appointment);

    Optional<Appointment> getAppointmentById(Long id);

    List<Appointment> getAppointmentsByPatientId(Long patientId);

    Optional<Appointment> updateAppointment(Appointment appointment);

    void deleteAppointment(Appointment appointment);

    void deleteAppointmentById(Long id);

    AppointmentDTO convertToDTO(Appointment appointment);

    List<AppointmentDTO> convertToDTOList(List<Appointment> appointments);

    Appointment convertToEntity(AppointmentDTO appointmentDTO);

    List<Appointment> getAppointmentListByStatus(Status status);
}
