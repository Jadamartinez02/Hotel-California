package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;
import scala.collection.immutable.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String roomTypeId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String statusId;
    @Column(nullable = false)
    private int roomNumber;
    @Column(nullable = false)
    private float priceNight;
    @Column(nullable = false)
    private int maxPeople;
    @Column(nullable = false)
    private boolean availability;
    
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "status_room_id", nullable = false)
    private StatusRoom statusRoom;



    
    
    public Room() {
    }

    
}