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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getQuantityBed() {
        return quantityBed;
    }

    public void setQuantityBed(Integer quantityBed) {
        this.quantityBed = quantityBed;
    }

    
        
}
