package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "beds")
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String type;
        
    public Bed() {
    }
    
 
}
