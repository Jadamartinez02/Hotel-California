package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_packages")
public class HotelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Float priceMultiplier;

    @OneToMany(mappedBy = "hotelPackage")
    private List<Reservation> reservations;

    public HotelPackage() {
    }

}
