package com.hotelcalifornia.hotelcalifornia.adapters.dto;


public class BedRoomDto {

    private String id;
    private String bedId;
    private String roomId;
    private Integer quantityBed;
    
    public BedRoomDto() {
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
