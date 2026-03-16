package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate starDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private Float priceMultiplier;

    @OneToMany(mappedBy = "season")
    private List<Reservation> reservations;
}
