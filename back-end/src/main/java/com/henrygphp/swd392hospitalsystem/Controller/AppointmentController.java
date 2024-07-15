package com.henrygphp.swd392hospitalsystem.Controller;

import com.henrygphp.swd392hospitalsystem.DTO.AppointmentInfoDTO;
import com.henrygphp.swd392hospitalsystem.DTO.Req.AddAppointmentReq;
import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import com.henrygphp.swd392hospitalsystem.Services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    // Add appointment
    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(Appointment appointment) {
        return new ResponseEntity<>(appointmentService.addAppointment(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/add")
    public ResponseEntity<AddAppointmentReq> getAppointmentMenu(){
        return new ResponseEntity<>(new AddAppointmentReq(), HttpStatus.OK);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentInfoDTO> getAppointmentById(@PathVariable Integer id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(value -> new ResponseEntity<>(new AppointmentInfoDTO(value.getAppointmentId(),
                        value.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        value.getAppointmentStartTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                                + " - " + value.getAppointmentEndTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                        value.getStatus(), value.getReason(), value.getPatient().getPatientId(),
                        value.getDoctor().getDoctorId()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get appointments by patient ID
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentInfoDTO>> getAppointmentsByPatientId(@PathVariable Integer id) {
        List<AppointmentInfoDTO> appointments = appointmentService.getAppointmentsByPatientId(id).stream().map(appointment -> new AppointmentInfoDTO(appointment.getAppointmentId(),
                appointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                appointment.getAppointmentStartTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                        + " - " + appointment.getAppointmentEndTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                appointment.getStatus(), appointment.getReason(), appointment.getPatient().getPatientId(),
                appointment.getDoctor().getDoctorId())).toList();
        //Check if the list is empty
        if(appointments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    //Get Future appointments by patient ID

    // Update appointment
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer id, Appointment appointment) {
        appointment.setAppointmentId(id);
        Optional<Appointment> updatedAppointment = appointmentService.updateAppointment(appointment);
        return updatedAppointment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete appointment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Appointment> deleteAppointmentById(@PathVariable Integer id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
