
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VoucherDatum implements Serializable  {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bookingcode")
    @Expose
    private String bookingcode;
    @SerializedName("downloadvoucher")
    @Expose
    private String downloadvoucher;
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

    /**
     * No args constructor for use in serialization
     * 
     */
    public VoucherDatum() {
    }

    /**
     * 
     * @param mobilenumber
     * @param vouchertype
     * @param voucherdate
     * @param downloadvoucher
     * @param id
     * @param packagevoucher
     * @param bookingcode
     * @param qid
     */
    public VoucherDatum(String id, String bookingcode, String downloadvoucher, String mobilenumber, String qid, String voucherdate, String packagevoucher, String vouchertype) {
        super();
        this.id = id;
        this.bookingcode = bookingcode;
        this.downloadvoucher = downloadvoucher;
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

    public String getDownloadvoucher() {
        return downloadvoucher;
    }

    public void setDownloadvoucher(String downloadvoucher) {
        this.downloadvoucher = downloadvoucher;
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
