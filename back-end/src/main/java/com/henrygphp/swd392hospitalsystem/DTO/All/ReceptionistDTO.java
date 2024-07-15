package com.henrygphp.swd392hospitalsystem.DTO.All;

import com.henrygphp.swd392hospitalsystem.Models.Appointment;
import com.henrygphp.swd392hospitalsystem.Models.Notification;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionistDTO {
    private Long receptionistId;

    private String firstName;

    private String lastName;

    private String PhoneNumber;

    private String email;
}
