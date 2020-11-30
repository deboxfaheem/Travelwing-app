
package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ActivityModel implements Serializable {

    @SerializedName("activityQuoteId")
    @Expose
    private String activityQuoteId;

    @SerializedName("serviceType")
    @Expose
    private String serviceType;

    @SerializedName("activityName")
    @Expose
    private String activityName;

    @SerializedName("activityImage")
    @Expose
    private String activityImage;

    @SerializedName("activityDetail")
    @Expose
    private String activityDetail;

    @SerializedName("startTime")
    @Expose
    private String startTime;

    @SerializedName("endTime")
    @Expose
    private String endTime;

    public ActivityModel(String activityQuoteId, String serviceType, String activityName, String activityImage, String activityDetail, String startTime, String endTime) {
        this.activityQuoteId = activityQuoteId;
        this.serviceType = serviceType;
        this.activityName = activityName;
        this.activityImage = activityImage;
        this.activityDetail = activityDetail;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getActivityQuoteId() {
        return activityQuoteId;
    }

    public void setActivityQuoteId(String activityQuoteId) {
        this.activityQuoteId = activityQuoteId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityImage() {
        return activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

