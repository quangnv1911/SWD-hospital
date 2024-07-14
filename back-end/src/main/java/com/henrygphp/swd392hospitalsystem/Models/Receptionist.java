package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Receptionist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receptionistId;

    private String firstName;

    private String lastName;

    @Pattern(regexp = "0[0-9]{9}")
    private String PhoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @OneToMany(mappedBy = "receptionist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointmentList = new ArrayList<>();
}
