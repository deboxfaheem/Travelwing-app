package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoucherModel {

    @SerializedName("tripName")
    @Expose
    private String tripName;

    @SerializedName("queryId")
    @Expose
    private String queryId;

    @SerializedName("invoicePdfLink")
    @Expose
    private String invoicePdfLink;

    public InvoucherModel(String tripName, String queryId, String invoicePdfLink) {
        this.tripName = tripName;
        this.queryId = queryId;
        this.invoicePdfLink = invoicePdfLink;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getInvoicePdfLink() {
        return invoicePdfLink;
    }

    public void setInvoicePdfLink(String invoicePdfLink) {
        this.invoicePdfLink = invoicePdfLink;
    }
}