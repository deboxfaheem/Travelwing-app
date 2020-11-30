package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelVoucherModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bookingcode")
    @Expose
    private String bookingcode;
    @SerializedName("hotelVoucher")
    @Expose
    private String hotelVoucher;
    @SerializedName("flightVoucher")
    @Expose
    private String flightVoucher;
    @SerializedName("mobilenumber")
    @Expose
    private String mobilenumber;
    @SerializedName("qid")
    @Expose
    private String qid;
    @SerializedName("voucherdate")
    @Expose
    private String voucherdate;
    @SerializedName("packagevoucher")
    @Expose
    private String packagevoucher;
    @SerializedName("vouchertype")
    @Expose
    private String vouchertype;

    public HotelVoucherModel(String id, String bookingcode, String hotelVoucher, String flightVoucher, String mobilenumber, String qid, String voucherdate, String packagevoucher, String vouchertype) {
        this.id = id;
        this.bookingcode = bookingcode;
        this.hotelVoucher = hotelVoucher;
        this.flightVoucher = flightVoucher;
        this.mobilenumber = mobilenumber;
        this.qid = qid;
        this.voucherdate = voucherdate;
        this.packagevoucher = packagevoucher;
        this.vouchertype = vouchertype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(String bookingcode) {
        this.bookingcode = bookingcode;
    }

    public String getHotelVoucher() {
        return hotelVoucher;
    }

    public void setHotelVoucher(String hotelVoucher) {
        this.hotelVoucher = hotelVoucher;
    }

    public String getFlightVoucher() {
        return flightVoucher;
    }

    public void setFlightVoucher(String flightVoucher) {
        this.flightVoucher = flightVoucher;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getVoucherdate() {
        return voucherdate;
    }

    public void setVoucherdate(String voucherdate) {
        this.voucherdate = voucherdate;
    }

    public String getPackagevoucher() {
        return packagevoucher;
    }

    public void setPackagevoucher(String packagevoucher) {
        this.packagevoucher = packagevoucher;
    }

    public String getVouchertype() {
        return vouchertype;
    }

    public void setVouchertype(String vouchertype) {
        this.vouchertype = vouchertype;
    }
}
