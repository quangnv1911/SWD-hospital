package com.henrygphp.swd392hospitalsystem.Controller;

import com.henrygphp.swd392hospitalsystem.DTO.All.AppointmentDTO;
import com.henrygphp.swd392hospitalsystem.Models.*;
import com.henrygphp.swd392hospitalsystem.Services.AppointmentService;
import com.henrygphp.swd392hospitalsystem.Services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    private final EmailService emailService;

    // Add appointment
    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(Appointment appointment) {
        //send email about new Appointment
        emailService.sendEmail(appointment.getPatient().getEmail(),
                "New Appointment",
                "Your appointment has been scheduled on " +
                        appointment.getAppointmentDate() +
                        " from " + appointment.getAppointmentStartTime()+
                        " to "+appointment.getAppointmentEndTime());
        return new ResponseEntity<>(appointmentService.addAppointment(appointment), HttpStatus.CREATED);
    }

//    @GetMapping("/add")
//    public ResponseEntity<AddAppointmentRespDTO> getAppointmentMenu(){
//        return new ResponseEntity<>(new AddAppointmentRespDTO(), HttpStatus.OK);
//    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(value -> new ResponseEntity<>(appointmentService.convertToDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get appointments by patient ID
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByPatientId(@PathVariable Long id) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(id);
        return new ResponseEntity<>(appointmentService.convertToDTOList(appointments), HttpStatus.OK);
    }

    //Get Future appointments by patient ID

    // Update appointment
//    @PutMapping("/{id}")
//    public ResponseEntity<UpdateAppointmentReqDTO> updateAppointment(@PathVariable Long id, @RequestBody UpdateAppointmentReqDTO appointmentDTO) {
//        //Check if the appointment exists
//        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
//        if (appointment.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        else{
//            Appointment newAppointment = new Appointment(
//                    appointmentDTO.getId(),
//                    LocalDate.parse(appointmentDTO.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
//                    LocalTime.parse(appointmentDTO.getStartTime(), DateTimeFormatter.ofPattern("HH:mm")),
//                    LocalTime.parse(appointmentDTO.getEndTime(), DateTimeFormatter.ofPattern("HH:mm")),
//                    appointmentDTO.getReason(),
//                    appointmentDTO.getStatus(),
//                    new Patient(appointmentDTO.getPatientId()),
//                    new Doctor(appointmentDTO.getDoctorId()),
//                    new Receptionist(appointmentDTO.getReceptionistId())
//            );
//            appointmentService.updateAppointment(newAppointment);
//            return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
//        }
//    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        //Check if the appointment exists
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        if (appointment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            String footer = "\n\nPlease be on time and bring your ID card with you.\n\nThank you!";

            Optional<Appointment> newAppointment = appointmentService.updateAppointment(appointmentService.convertToEntity(appointmentDTO));

            String patientName = "Dear "+newAppointment.get().getPatient().getFirstName()+" "+newAppointment.get().getPatient().getLastName();

            String contentHeader = "\nYour appointment status has been updated to " + newAppointment.get().getStatus();

            String content = "\nScheduled on " +
                    newAppointment.get().getAppointmentDate() +
                    " from " + newAppointment.get().getAppointmentStartTime()+
                    " to "+newAppointment.get().getAppointmentEndTime();

            //send email about the appointment status
            emailService.sendEmail(newAppointment.get().getPatient().getEmail(), "Appointment Status", "Your appointment has been updated!\n"+patientName + contentHeader + content + footer);

            return new ResponseEntity<>(appointmentService.convertToDTO(newAppointment.get()), HttpStatus.OK);
        }
    }

    // Delete appointment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Appointment> deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Get Appointment List of patient by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentListByStatus(@PathVariable Status status) {
        return new ResponseEntity<>(appointmentService.convertToDTOList(appointmentService.getAppointmentListByStatus(status)), HttpStatus.OK);
    }
}
