package com.travelwings.trav_client.Models;

import java.io.Serializable;

public class DocumentModel implements Serializable {


    String id;



    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    String documentType;
    String documentNo;
    String country;
    String issueDate;
    String expiryDate;

    public Boolean getIsdoc() {
        return isdoc;
    }

    public void setIsdoc(Boolean isdoc) {
        this.isdoc = isdoc;
    }

    Boolean isdoc=false;



    String imageurl;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageurl2() {
        return imageurl2;
    }

    public void setImageurl2(String imageurl2) {
        this.imageurl2 = imageurl2;
    }

    String imageurl2;

    public String getDocument_image() {
        return document_image;
    }

    public void setDocument_image(String document_image) {
        this.document_image = document_image;
    }

    String document_image;

    public DocumentModel(String id, String documentType, String documentNo, String country, String issueDate, String expiryDate) {
        this.id = id;
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
