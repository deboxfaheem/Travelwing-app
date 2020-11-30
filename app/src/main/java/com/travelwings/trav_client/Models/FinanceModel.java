package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinanceModel {

    @SerializedName("tripId")
    @Expose
    private String tripId;

    @SerializedName("totalClientCost")
    @Expose
    private String totalClientCost;

    @SerializedName("received")
    @Expose
    private String received;

    @SerializedName("pendingCost")
    @Expose
    private String pendingCost;

    public FinanceModel(String tripId, String totalClientCost, String received, String pendingCost) {
        this.tripId = tripId;
        this.totalClientCost = totalClientCost;
        this.received = received;
        this.pendingCost = pendingCost;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTotalClientCost() {
        return totalClientCost;
    }

    public void setTotalClientCost(String totalClientCost) {
        this.totalClientCost = totalClientCost;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getPendingCost() {
        return pendingCost;
    }

    public void setPendingCost(String pendingCost) {
        this.pendingCost = pendingCost;
    }
}
