package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionMedicationKey implements Serializable {
    private Long prescriptionId;
    private Long medicationId;
}
