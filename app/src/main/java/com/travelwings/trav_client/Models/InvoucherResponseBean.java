package com.travelwings.trav_client.Models;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class InvoucherResponseBean implements Serializable {
    public String status;
    public ArrayList<InvoucherModel> results;

    public static InvoucherResponseBean fromJson(String json) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, InvoucherResponseBean.class);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Response: " + e.getMessage() );
            return null;
        }
    }

}
