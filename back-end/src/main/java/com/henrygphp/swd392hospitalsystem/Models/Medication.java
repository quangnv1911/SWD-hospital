package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrescriptionMedication> prescriptionMedicationList;

}
