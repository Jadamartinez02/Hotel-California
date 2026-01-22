package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String roomId;
    @Column(nullable = false)
    private int roomNumber;
    @Column(nullable = false)
    private float priceNight;
    @Column(nullable = false)
    private int maxPeople;
    @Column(nullable = false)
    private boolean availability;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String roomTypeId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String statusId;
    
    public Room() {
    }

    public Room(String roomId, int roomNumber, float priceNight, int maxPeople, boolean availability, String roomTypeId,
            String statusId) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.priceNight = priceNight;
        this.maxPeople = maxPeople;
        this.availability = availability;
        this.roomTypeId = roomTypeId;
        this.statusId = statusId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(float priceNight) {
        this.priceNight = priceNight;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    
    
}