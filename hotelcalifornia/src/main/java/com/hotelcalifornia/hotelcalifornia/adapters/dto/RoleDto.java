package com.hotelcalifornia.hotelcalifornia.adapters.dto;

public class RoleDto {
    private String id;
    private String name;
    private Boolean canEditRoom;
    private Boolean canViewRoom;
    private Boolean canPostOffers;
    private Boolean canEditPackage;
    
    public RoleDto() {
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
    public Boolean getCanEditRoom() {
        return canEditRoom;
    }
    public void setCanEditRoom(Boolean canEditRoom) {
        this.canEditRoom = canEditRoom;
    }
    public Boolean getCanViewRoom() {
        return canViewRoom;
    }
    public void setCanViewRoom(Boolean canViewRoom) {
        this.canViewRoom = canViewRoom;
    }
    public Boolean getCanPostOffers() {
        return canPostOffers;
    }
    public void setCanPostOffers(Boolean canPostOffers) {
        this.canPostOffers = canPostOffers;
    }
    public Boolean getCanEditPackage() {
        return canEditPackage;
    }
    public void setCanEditPackage(Boolean canEditPackage) {
        this.canEditPackage = canEditPackage;
    }

    
}
