package com.travelwings.trav_client.Models;

public class SightseeingModel {


    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSightseeing() {
        return sightseeing;
    }

    public void setSightseeing(String sightseeing) {
        this.sightseeing = sightseeing;
    }

    public SightseeingModel(String id, String sightseeing) {
        this.id = id;
        this.sightseeing = sightseeing;
    }

    String sightseeing;
}
