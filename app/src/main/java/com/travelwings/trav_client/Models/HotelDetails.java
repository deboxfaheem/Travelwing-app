package com.travelwings.trav_client.Models;

public class HotelDetails {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public HotelDetails(String id, String hotelname) {
        this.id = id;
        this.hotelname = hotelname;
    }

    String hotelname;


}
