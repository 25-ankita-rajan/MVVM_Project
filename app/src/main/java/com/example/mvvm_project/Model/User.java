package com.example.mvvm_project.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("is_merchant")
    @Expose
    private Boolean isMerchant;
    @SerializedName("is_customer")
    @Expose
    private Boolean isCustomer;
    @SerializedName("url")
    @Expose
    private String url;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsMerchant() {
        return isMerchant;
    }

    public void setIsMerchant(Boolean isMerchant) {
        this.isMerchant = isMerchant;
    }

    public Boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
