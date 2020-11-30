package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("queryId")
    @Expose
    private String queryId;
    @SerializedName("entranceImage")
    @Expose
    private String entranceImage;
    @SerializedName("tripName")
    @Expose
    private String tripName;
    @SerializedName("tripDuration")
    @Expose
    private String tripDuration;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TripModel() {
    }

    /**
     * 
     * @param date
     * @param entranceImage
     * @param tripName
     * @param id
     * @param tripDuration
     * @param day
     * @param queryId
     */
    public TripModel(String id, String date, String day, String queryId, String entranceImage, String tripName, String tripDuration) {
        super();
        this.id = id;
        this.date = date;
        this.day = day;
        this.queryId = queryId;
        this.entranceImage = entranceImage;
        this.tripName = tripName;
        this.tripDuration = tripDuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getEntranceImage() {
        return entranceImage;
    }

    public void setEntranceImage(String entranceImage) {
        this.entranceImage = entranceImage;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(String tripDuration) {
        this.tripDuration = tripDuration;
    }

}
