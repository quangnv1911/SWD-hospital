package com.henrygphp.swd392hospitalsystem.Repositories;

import com.henrygphp.swd392hospitalsystem.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
