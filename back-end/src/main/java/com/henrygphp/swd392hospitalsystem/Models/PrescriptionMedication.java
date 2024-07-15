package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Prescription_Medication")
public class PrescriptionMedication {
    @EmbeddedId
    private PrescriptionMedicationKey id;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

    private Integer quantity;
}

