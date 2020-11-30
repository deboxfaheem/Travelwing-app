
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ItenaryModel implements Serializable {
    @SerializedName("quotationId")
    @Expose
    private String quotationId;

    @SerializedName("fromDate")
    @Expose
    private String fromDate;

    @SerializedName("toDate")
    @Expose
    private String toDate;

    @SerializedName("subject")
    @Expose
    private String subject;

    @SerializedName("proposalPhoto")
    @Expose
    private String proposalPhoto;

    @SerializedName("days")
    @Expose
    private ArrayList<DayModel> days;

    public ItenaryModel(String quotationId, String fromDate, String toDate, String subject, String proposalPhoto, ArrayList<DayModel> days) {
        this.quotationId = quotationId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.subject = subject;
        this.proposalPhoto = proposalPhoto;
        this.days = days;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProposalPhoto() {
        return proposalPhoto;
    }

    public void setProposalPhoto(String proposalPhoto) {
        this.proposalPhoto = proposalPhoto;
    }

    public ArrayList<DayModel> getDays() {
        return days;
    }

    public void setDays(ArrayList<DayModel> days) {
        this.days = days;
    }
}

