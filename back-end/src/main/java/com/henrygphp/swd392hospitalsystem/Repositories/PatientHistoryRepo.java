package com.henrygphp.swd392hospitalsystem.Repositories;

import com.henrygphp.swd392hospitalsystem.Models.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientHistoryRepo extends JpaRepository<PatientHistory, Long> {
    List<PatientHistory> findAllByPatient_PatientId(Long patientId);
}
