
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlightModel implements Serializable {

    @SerializedName("flightQuoteId")
    @Expose
    private String flightQuoteId;

    @SerializedName("serviceType")
    @Expose
    private String serviceType;

    @SerializedName("flightName")
    @Expose
    private String flightName;

    @SerializedName("flightClass")
    @Expose
    private String flightClass;

    @SerializedName("flightNumber")
    @Expose
    private String flightNumber;

    @SerializedName("voucherUrl")
    @Expose
    private String voucherUrl;

    @SerializedName("fromDest")
    @Expose
    private String fromDest;

    @SerializedName("toDest")
    @Expose
    private String toDest;

    @SerializedName("arrivalDate")
    @Expose
    private String arrivalDate;

    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;

    @SerializedName("departureDate")
    @Expose
    private String departureDate;

    @SerializedName("departureTime")
    @Expose
    private String departureTime;

    public FlightModel(String flightQuoteId, String serviceType, String flightName, String flightClass, String flightNumber, String voucherUrl, String fromDest, String toDest, String arrivalDate, String arrivalTime, String departureDate, String departureTime) {
        this.flightQuoteId = flightQuoteId;
        this.serviceType = serviceType;
        this.flightName = flightName;
        this.flightClass = flightClass;
        this.flightNumber = flightNumber;
        this.voucherUrl = voucherUrl;
        this.fromDest = fromDest;
        this.toDest = toDest;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    public String getFlightQuoteId() {
        return flightQuoteId;
    }

    public void setFlightQuoteId(String flightQuoteId) {
        this.flightQuoteId = flightQuoteId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getVoucherUrl() {
        return voucherUrl;
    }

    public void setVoucherUrl(String voucherUrl) {
        this.voucherUrl = voucherUrl;
    }

    public String getFromDest() {
        return fromDest;
    }

    public void setFromDest(String fromDest) {
        this.fromDest = fromDest;
    }

    public String getToDest() {
        return toDest;
    }

    public void setToDest(String toDest) {
        this.toDest = toDest;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}

