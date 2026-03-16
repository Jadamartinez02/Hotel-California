package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_rooms")
public class StatusRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String statusId;

    @Column(nullable = false)
    private String status;
    private String description;
    
    @OneToMany(mappedBy = "statusRoom")
    private List<Room> rooms;

    public StatusRoom() {
    }

}
