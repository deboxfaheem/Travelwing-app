package com.travelwings.trav_client.Models;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class ItenraryResponseBean implements Serializable {


    public String status;
    public ArrayList<ItenaryModel> results = new ArrayList<>();

    public static ItenraryResponseBean fromJson(String json) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, ItenraryResponseBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error", "Response: " + e.getMessage());
            return null;
        }
    }
}

