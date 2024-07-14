package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Appointment")
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer appointmentId;

    private LocalDate appointmentDate;

    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndTime;

    private String reason;

    private String status;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "receptionistId")
    private Receptionist receptionist;
}
