package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "TestResult")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testResultId;

    private String result;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
