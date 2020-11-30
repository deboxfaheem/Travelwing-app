package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResendModel {

    @SerializedName("otp")
    @Expose
    private String otp;

    @SerializedName("error")
    @Expose
    private String error;

    public ResendModel(String otp, String error) {
        this.otp = otp;
        this.error = error;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
