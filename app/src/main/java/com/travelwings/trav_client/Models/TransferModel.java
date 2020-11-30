package com.travelwings.trav_client.Models;

public class TransferModel {


    String id;

    public TransferModel(String id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    String destination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
