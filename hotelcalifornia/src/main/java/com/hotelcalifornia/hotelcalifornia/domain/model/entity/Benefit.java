package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;

@Entity
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private Float price;
    

    public Benefit() {
    }

}

