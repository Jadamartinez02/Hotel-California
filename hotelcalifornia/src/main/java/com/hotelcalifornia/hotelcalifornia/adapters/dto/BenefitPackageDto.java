package com.hotelcalifornia.hotelcalifornia.adapters.dto;


public class BenefitPackageDto {

    private String id;
    private String packageId;
    private String benefitId;
    
    public BenefitPackageDto() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPackageId() {
        return packageId;
    }
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    public String getBenefitId() {
        return benefitId;
    }
    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    
}
