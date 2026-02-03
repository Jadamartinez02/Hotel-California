package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;
@Entity
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String type;
        
    public Bed() {
    }
    
 
}
