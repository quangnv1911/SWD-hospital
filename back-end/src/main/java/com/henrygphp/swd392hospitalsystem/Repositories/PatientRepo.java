package com.henrygphp.swd392hospitalsystem.Repositories;

import com.henrygphp.swd392hospitalsystem.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
}
