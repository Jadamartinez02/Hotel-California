package com.hotelcalifornia.hotelcalifornia.adapters.dto;


public class RoomDto {
    
    private String id;
    private int number;
    private float priceNight;
    private int maxPeople;
    private boolean availability;
    private String typeId;
    private String statusId;
    
    public RoomDto() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
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
    public String getTypeId() {
        return typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getStatusId() {
        return statusId;
    }
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

}
