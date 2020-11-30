package com.travelwings.trav_client.rest;

import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.HotelModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.Result;

import java.util.ArrayList;

public interface MyClickEvents {

      //  void onDemoClick(String vouchername, int postion);
        void onListClick(ArrayList<HotelModel> results, int postion);
    //  void onDemoClick(String vouchername, int postion);
}
