package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;
import scala.collection.immutable.List;

@Entity
public class HotelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Float priceMultiplier;

    @OneToMany(mappedBy = "package")
    private List<Reservation> reservations;

    public HotelPackage() {
    }

}
