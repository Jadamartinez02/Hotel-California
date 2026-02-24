package com.hotelcalifornia.hotelcalifornia.adapters.dto;

import java.time.LocalDate;

public class ReservationDto {
    private String id;
    private String seasonId;
    private String StatusReservationId;
    private String benefitPackageId;
    private String roomId;
    private String userId;
    private LocalDate checkIn;
    private LocalDate checkout;
    
    public ReservationDto() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSeasonId() {
        return seasonId;
    }
    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }
    public String getStatusReservationId() {
        return StatusReservationId;
    }
    public void setStatusReservationId(String statusReservationId) {
        StatusReservationId = statusReservationId;
    }
    public String getBenefitPackageId() {
        return benefitPackageId;
    }
    public void setBenefitPackageId(String benefitPackageId) {
        this.benefitPackageId = benefitPackageId;
    }
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    public LocalDate getCheckout() {
        return checkout;
    }
    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    

}
