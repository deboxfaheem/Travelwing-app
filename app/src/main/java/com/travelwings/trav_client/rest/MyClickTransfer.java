package com.travelwings.trav_client.rest;

import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.FlightModel;
import com.travelwings.trav_client.Models.HotelModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.Result;

import java.util.ArrayList;

public interface MyClickTransfer {


        void onTransferClick(ArrayList<FlightModel> results, int postion);

}