package com.travelwings.trav_client.Models;

public class InvoiceModel {

    String  id;
    String invoicename;
    String invoicefullurl;
    String mobilenumber;
    String downloadpdf;
    String queryid;
    String invoicedate;
    String invoicetype;
    String client;
    String finalcost;

    public InvoiceModel(String id, String invoicename, String invoicefullurl, String mobilenumber, String downloadpdf,
                        String invoicedate,
                        String invoicetype, String client, String finalcost, String qid) {
        this.id = id;
        this.invoicename = invoicename;
        this.invoicefullurl = invoicefullurl;
        this.mobilenumber = mobilenumber;
        this.downloadpdf = downloadpdf;
        this.invoicedate = invoicedate;
        this.invoicetype = invoicetype;
        this.client = client;
        this.finalcost = finalcost;
        this.qid = qid;
    }

    public String getFinalcost() {
        return finalcost;
    }

    public void setFinalcost(String finalcost) {
        this.finalcost = finalcost;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    String qid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoicename() {
        return invoicename;
    }

    public void setInvoicename(String invoicename) {
        this.invoicename = invoicename;
    }

    public String getInvoicefullurl() {
        return invoicefullurl;
    }

    public void setInvoicefullurl(String invoicefullurl) {
        this.invoicefullurl = invoicefullurl;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getDownloadpdf() {
        return downloadpdf;
    }

    public void setDownloadpdf(String downloadpdf) {
        this.downloadpdf = downloadpdf;
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

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

}
