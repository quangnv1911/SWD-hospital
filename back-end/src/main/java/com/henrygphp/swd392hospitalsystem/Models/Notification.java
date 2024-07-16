package com.henrygphp.swd392hospitalsystem.Models;

import jakarta.persistence.*;

import javax.lang.model.element.Name;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;
    private String message;

    @ManyToOne
    @JoinColumn(name = "receptionist_id")
    private Receptionist receptionist;
}
