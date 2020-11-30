package com.travelwings.trav_client.Models;

public class VoucherModel {




    String id;
    String voucherid;
    String bookingcode;
    String voucherlink;
    String downloadvoucher;

    public String getVoucherdate() {
        return voucherdate;
    }

    public void setVoucherdate(String voucherdate) {
        this.voucherdate = voucherdate;
    }

    String voucherdate;

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    String mobilenumber;



    public VoucherModel(String id,  String bookingcode, String voucherlink,String mobilenumber, String downloadvoucher, String queryid,  String packagevoucher, String invoicetype,String voucherdate ) {
        this.id = id;
      //  this.voucherid = voucherid;
        this.bookingcode = bookingcode;
        this.voucherlink = voucherlink;
        this.downloadvoucher = downloadvoucher;
        this.mobilenumber = mobilenumber;
        this.queryid = queryid;
        this.voucherdate = voucherdate;
        this.packagevoucher = packagevoucher;
        this.invoicetype = invoicetype;
    }

    String queryid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoucherid() {
        return voucherid;
    }

    public void setVoucherid(String voucherid) {
        this.voucherid = voucherid;
    }

    public String getBookingcode() {
        return bookingcode;
    }

    public void setBookingcode(String bookingcode) {
        this.bookingcode = bookingcode;
    }

    public String getVoucherlink() {
        return voucherlink;
    }

    public void setVoucherlink(String voucherlink) {
        this.voucherlink = voucherlink;
    }

    public String getDownloadvoucher() {
        return downloadvoucher;
    }

    public void setDownloadvoucher(String downloadvoucher) {
        this.downloadvoucher = downloadvoucher;
    }

    public String getQueryid() {
        return queryid;
    }

    public void setQueryid(String queryid) {
        this.queryid = queryid;
    }

    public String getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(String invoicedate) {
        this.invoicedate = invoicedate;
    }

    public String getPackagevoucher() {
        return packagevoucher;
    }

    public void setPackagevoucher(String packagevoucher) {
        this.packagevoucher = packagevoucher;
    }

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype;
    }

    String invoicedate;
    String packagevoucher;
    String invoicetype;

}
