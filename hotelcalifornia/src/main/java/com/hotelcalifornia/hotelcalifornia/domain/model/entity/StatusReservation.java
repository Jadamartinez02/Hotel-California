package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;
import scala.collection.immutable.List;

@Entity
public class StatusReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "statusReservation")
    private List<Reservation> reservations;

    public StatusReservation() {
    }

    public StatusReservation(String id, String name, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.reservations = reservations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
   
}
