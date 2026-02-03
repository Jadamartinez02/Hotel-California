package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;

@Entity
public class BenefitPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String packageId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String benefitId;

    
    public BenefitPackage() {
    }
   
}
