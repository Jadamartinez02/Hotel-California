package com.hotelcalifornia.hotelcalifornia.domain.model.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String seasonId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String statusReservationId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String packageId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String roomId;
    @Column(nullable = false, columnDefinition = "CHAR(36)")
    private String userId;
    @Column(nullable = false)
    private LocalDate checkIn;
    @Column(nullable = false)
    private LocalDate checkout;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private HotelPackage hotelPackage;
    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;
    @ManyToOne
    @JoinColumn(name = "status_reservation_id", nullable = false)
    private StatusReservation statusReservation;
    
    public Reservation() {
    }

    public Reservation(String id, String seasonId, String statusReservationId, String packageId, String roomId,
            String userId, LocalDate checkIn, LocalDate checkout, Room room, HotelPackage hotelPackage,
            Season season, StatusReservation statusReservation) {
        this.id = id;
        this.seasonId = seasonId;
        this.statusReservationId = statusReservationId;
        this.packageId = packageId;
        this.roomId = roomId;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.room = room;
        this.hotelPackage = hotelPackage;
        this.season = season;
        this.statusReservation = statusReservation;
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
        return statusReservationId;
    }

    public void setStatusReservationId(String statusReservationId) {
        this.statusReservationId = statusReservationId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HotelPackage getHotelPackage() {
        return hotelPackage;
    }

    public void setHotelPackage(HotelPackage hotelPackage) {
        this.hotelPackage = hotelPackage;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public StatusReservation getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation) {
        this.statusReservation = statusReservation;
    }

}
