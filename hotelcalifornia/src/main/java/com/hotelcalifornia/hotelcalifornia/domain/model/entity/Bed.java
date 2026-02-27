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

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
 
}
