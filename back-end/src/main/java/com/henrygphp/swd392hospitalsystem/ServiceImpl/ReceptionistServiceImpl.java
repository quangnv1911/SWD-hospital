package com.henrygphp.swd392hospitalsystem.ServiceImpl;

import com.henrygphp.swd392hospitalsystem.Models.Receptionist;
import com.henrygphp.swd392hospitalsystem.Repositories.ReceptionistRepo;
import com.henrygphp.swd392hospitalsystem.Services.ReceptionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptionistServiceImpl implements ReceptionistService {
    private final ReceptionistRepo receptionistRepo;

    @Override
    public Optional<Receptionist> getReceptionistById(Long id) {
        return receptionistRepo.findById(id);
    }
}
