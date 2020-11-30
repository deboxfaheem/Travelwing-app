package com.travelwings.trav_client.Models;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;

public class WeatherResponseBean implements Serializable {

    public String timezone;

    public static WeatherResponseBean fromJson(String json) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, WeatherResponseBean.class);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Response: " + e.getMessage() );
            return null;
        }
    }



}
