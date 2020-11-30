
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HotelModel implements Serializable {

    @SerializedName("hotelQuoteId")
    @Expose
    private String hotelQuoteId;

    @SerializedName("serviceType")
    @Expose
    private String serviceType;

    @SerializedName("hotelName")
    @Expose
    private String hotelName;

    @SerializedName("voucherUrl")
    @Expose
    private String voucherUrl;

    @SerializedName("hotelImage")
    @Expose
    private String hotelImage;

    @SerializedName("hotelcategory")
    @Expose
    private String hotelcategory;

    @SerializedName("roomType")
    @Expose
    private String roomType;

    @SerializedName("mealPlan")
    @Expose
    private String mealPlan;

    public HotelModel(String hotelQuoteId, String serviceType, String hotelName, String voucherUrl, String hotelImage, String hotelcategory, String roomType, String mealPlan) {
        this.hotelQuoteId = hotelQuoteId;
        this.serviceType = serviceType;
        this.hotelName = hotelName;
        this.voucherUrl = voucherUrl;
        this.hotelImage = hotelImage;
        this.hotelcategory = hotelcategory;
        this.roomType = roomType;
        this.mealPlan = mealPlan;
    }

    public String getHotelQuoteId() {
        return hotelQuoteId;
    }

    public void setHotelQuoteId(String hotelQuoteId) {
        this.hotelQuoteId = hotelQuoteId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getVoucherUrl() {
        return voucherUrl;
    }

    public void setVoucherUrl(String voucherUrl) {
        this.voucherUrl = voucherUrl;
    }

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
    }

    public String getHotelcategory() {
        return hotelcategory;
    }

    public void setHotelcategory(String hotelcategory) {
        this.hotelcategory = hotelcategory;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }
}

