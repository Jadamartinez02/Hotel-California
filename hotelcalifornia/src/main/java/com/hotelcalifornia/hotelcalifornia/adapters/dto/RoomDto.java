package com.hotelcalifornia.hotelcalifornia.adapters.dto;

import jakarta.persistence.Column;

public class RoomDto {
    private String id;
    private int number;
    private float priceNight;
    private int maxPeople;
    private boolean availability;
    private String typeId;
    private String statusId;

}
