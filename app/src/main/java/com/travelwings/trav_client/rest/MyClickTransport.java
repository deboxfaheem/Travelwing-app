package com.travelwings.trav_client.rest;

import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.FlightModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.ItenraryResponseBean;
import com.travelwings.trav_client.Models.Result;

import java.util.ArrayList;

public interface MyClickTransport {


        void onTransportClick(ArrayList<FlightModel> results, int postion);

}
