package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.DTO.All.AppointmentDTO;
import com.henrygphp.swd392hospitalsystem.DTO.All.DoctorDTO;
import com.henrygphp.swd392hospitalsystem.DTO.All.PatientDTO;
import com.henrygphp.swd392hospitalsystem.DTO.All.ReceptionistDTO;
import com.henrygphp.swd392hospitalsystem.Models.*;
import com.henrygphp.swd392hospitalsystem.Repositories.AppointmentRepo;
import com.henrygphp.swd392hospitalsystem.Services.AppointmentService;
import com.henrygphp.swd392hospitalsystem.Services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final DoctorService doctorService;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepo.findById(id);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
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
    public void deleteAppointmentById(Long id) {
        appointmentRepo.deleteById(id);
    }

    @Override
    public AppointmentDTO convertToDTO(Appointment appointment) {
        Doctor doctor = appointment.getDoctor();
        Patient patient = appointment.getPatient();
        Receptionist receptionist = appointment.getReceptionist();
        //covert to doctorDTO
        DoctorDTO doctorDTO = new DoctorDTO(doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getSpeciality());
        //convert to patientDTO
        PatientDTO patientDTO = new PatientDTO(patient.getPatientId(), patient.getFirstName(), patient.getLastName(), patient.getPhoneNumber(), patient.getEmail(), patient.getAddress(), patient.getDob().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), patient.getGender());
        //convert to receptionistDTO
        ReceptionistDTO receptionistDTO = new ReceptionistDTO(receptionist.getReceptionistId(), receptionist.getFirstName(), receptionist.getLastName(), receptionist.getPhoneNumber(), receptionist.getEmail());

        return new AppointmentDTO(appointment.getAppointmentId(),
                appointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                appointment.getAppointmentStartTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                appointment.getAppointmentEndTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                appointment.getStatus(),
                appointment.getReason(),
                doctorDTO,
                patientDTO,
                receptionistDTO);
    }

    @Override
    public List<AppointmentDTO> convertToDTOList(List<Appointment> appointments) {
        return appointments.stream().map(a -> convertToDTO(a)).toList();
    }

    @Override
    public Appointment convertToEntity(AppointmentDTO appointmentDTO) {
        return null;
    }

    @Override
    public List<Appointment> getAppointmentListByStatus(Status status) {
        return appointmentRepo.findByStatus(status);
    }
}
