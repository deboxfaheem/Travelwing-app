package com.travelwings.trav_client.Models;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;

public class SignupResponseBean implements Serializable {
    public String message;
    public static SignupResponseBean fromJson(String json) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, SignupResponseBean.class);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Response: " + e.getMessage() );
            return null;
        }
    }

}
