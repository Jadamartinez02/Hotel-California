package com.hotelcalifornia.hotelcalifornia.adapters.dto;

public class PackageDto {

    private String id;
    private String name;
    private Float priceMultiplier;

    public PackageDto() {
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
    public Float getPriceMultiplier() {
        return priceMultiplier;
    }
    public void setPriceMultiplier(Float priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

}
