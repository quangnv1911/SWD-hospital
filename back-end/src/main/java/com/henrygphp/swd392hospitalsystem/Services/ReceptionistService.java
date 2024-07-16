package com.henrygphp.swd392hospitalsystem.Services;

import com.henrygphp.swd392hospitalsystem.Models.Receptionist;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReceptionistService {
    //get receptionist by id
    Optional<Receptionist> getReceptionistById(Long id);
}
