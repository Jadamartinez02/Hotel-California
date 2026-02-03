package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;

@Entity
public class BedRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String bedId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String roomId;
    @Column(nullable = false)
    private Integer quantityBed;
    
    public BedRoom() {
    }

        
}
