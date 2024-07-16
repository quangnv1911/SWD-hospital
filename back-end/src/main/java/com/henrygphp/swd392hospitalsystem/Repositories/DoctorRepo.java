package com.henrygphp.swd392hospitalsystem.Repositories;

import com.henrygphp.swd392hospitalsystem.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    @Query("SELECT d FROM Doctor d WHERE d.doctorId NOT IN (SELECT a.doctor.doctorId FROM Appointment a WHERE a.appointmentDate = :date AND ((a.appointmentStartTime <= :startTime AND a.appointmentEndTime > :startTime) OR (a.appointmentStartTime < :endTime AND a.appointmentEndTime >= :endTime) OR (a.appointmentStartTime >= :startTime AND a.appointmentEndTime <= :endTime)))")
    List<Doctor> findAllAvailableDoctors(@Param("date") LocalDate date, @Param("startTime") LocalTime startTime, @Param("endTime") LocalTime endTime);
}
