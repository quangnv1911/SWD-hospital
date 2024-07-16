package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Appointment")
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long appointmentId;

    private LocalDate appointmentDate;

    private LocalTime appointmentStartTime;
    private LocalTime appointmentEndTime;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status;

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

