package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import jakarta.persistence.*;

@Entity
public class Room {
    private String roomId;
    private int roomNumber;
    private float priceNight;
    private int maxPeople;
    private boolean availability;
    private String roomTypeId;
    private String statusId;
}