package com.travelwings.trav_client.Models;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;

public class CovidVoucherResponseBean implements Serializable {
    public String covid19pdf;
    public static CovidVoucherResponseBean fromJson(String json) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, CovidVoucherResponseBean.class);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Response: " + e.getMessage() );
            return null;
        }
    }

}
