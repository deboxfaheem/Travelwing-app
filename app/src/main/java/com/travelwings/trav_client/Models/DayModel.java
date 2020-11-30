
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DayModel implements Serializable {

    @SerializedName("day")
    @Expose
    private String day;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("dayId")
    @Expose
    private String dayId;

    @SerializedName("cityId")
    @Expose
    private String cityId;

    @SerializedName("hotel")
    @Expose
    private ArrayList<HotelModel> hotel = null;

    @SerializedName("activity")
    @Expose
    private ArrayList<ActivityModel> activity = null;

    @SerializedName("flight")
    @Expose
    private ArrayList<FlightModel> flight = null;

    public DayModel(String day, String date, String dayId, String cityId, ArrayList<HotelModel> hotel, ArrayList<ActivityModel> activity, ArrayList<FlightModel> flight) {
        this.day = day;
        this.date = date;
        this.dayId = dayId;
        this.cityId = cityId;
        this.hotel = hotel;
        this.activity = activity;
        this.flight = flight;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public ArrayList<HotelModel> getHotel() {
        return hotel;
    }

    public void setHotel(ArrayList<HotelModel> hotel) {
        this.hotel = hotel;
    }

    public ArrayList<ActivityModel> getActivity() {
        return activity;
    }

    public void setActivity(ArrayList<ActivityModel> activity) {
        this.activity = activity;
    }

    public ArrayList<FlightModel> getFlight() {
        return flight;
    }

    public void setFlight(ArrayList<FlightModel> flight) {
        this.flight = flight;
    }
}

