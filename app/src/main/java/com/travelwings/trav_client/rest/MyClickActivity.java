package com.travelwings.trav_client.rest;

import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.FlightModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.Result;

import java.util.ArrayList;

public interface MyClickActivity {


        void onActivtiyClick(ArrayList<FlightModel> results, int postion);

}
