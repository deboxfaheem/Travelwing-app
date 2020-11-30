
package com.travelwings.trav_client.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassportExpiryModel {
    @SerializedName("clientName")
    @Expose
    private String clientName;

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private List<PassportExpiryModel> results = null;

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("documentType")
    @Expose
    private String documentType;
    @SerializedName("documentNo")
    @Expose
    private String documentNo;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("issueDate")
    @Expose
    private String issueDate;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public PassportExpiryModel() {
    }

    /**
     *
     * @param results
     * @param status
     */
    public PassportExpiryModel(String status, List<PassportExpiryModel> results) {
        super();
        this.status = status;
        this.results = results;
        this.id = id;
        this.clientName = clientName;
        this.documentType = documentType;
        this.documentNo = documentNo;
        this.country = country;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;

    }

    public PassportExpiryModel(String clientName,  String documentNo, String issueDate, String expiryDate) {
        this.clientName = clientName;
        this.documentNo = documentNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public List<PassportExpiryModel> getResults() {
        return results;
    }

    public String getId() {
        return id;
    }
    public String getClientName() {
        return clientName;
    }
    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public String getCountry() {
        return country;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
