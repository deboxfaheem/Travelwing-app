package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TermModel {

    @SerializedName("termscondition")
    @Expose
    private String termscondition;

    public TermModel(String termscondition) {
        this.termscondition = termscondition;
    }

    public String getTermscondition() {
        return termscondition;
    }

    public void setTermscondition(String termscondition) {
        this.termscondition = termscondition;
    }
}
