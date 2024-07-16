package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private String name;

//    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Medication> medicationList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrescriptionMedication> prescriptionMedicationList;
}
