
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Resultpas  implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("clientName")
    @Expose
    private String clientName;
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
     * @param id
     * @param documentType
     * @param documentNo
     * @param country
     * @param issueDate
     * @param expiryDate
     */
    public Resultpas(String id, String documentType, String documentNo, String country, String issueDate, String expiryDate) {
    }

    /**
     * 
     * @param expiryDate
     * @param documentNo
     * @param country
     * @param clientName
     * @param documentType
     * @param id
     * @param issueDate
     */
    public Resultpas(String id, String clientName, String documentType, String documentNo, String country, String issueDate, String expiryDate) {
        super();
        this.id = id;
        this.clientName = clientName;
        this.documentType = documentType;
        this.documentNo = documentNo;
        this.country = country;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}
