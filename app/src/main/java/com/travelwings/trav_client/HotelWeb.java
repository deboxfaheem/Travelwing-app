package com.travelwings.trav_client;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.ItenraryResponseBean;
import com.travelwings.trav_client.Models.Result;
import com.travelwings.trav_client.Models.ResultResponseBean;

import java.util.ArrayList;

public class HotelWeb extends AppCompatActivity {

    private String userid;
    private String usertype;
    ArrayList<ItenaryModel> result=new ArrayList<>();

    WebView m_webview;
  //  ArrayList<HotelVoucherModel> hotelVoucherModels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_web);
        m_webview = findViewById(R.id.trav_webview_WB);


        SharedPreferences sharedPreferences = HotelWeb.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");

        getitinerary();
    }

    public void getitinerary() {

     //   String url= "http://tw-worldwideholidays.com/live/api/json_itenerarydays.php?type=1&id=1";
        String url = AppNetworkConstants.ITENERARY +"type="+usertype+"&id="+userid;
        // final String url =  "http://deboxglobal.co.in/travcrm-latestinbound/api/json_itenerarydays.php?id=671&type=2";
     //   final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_itenerarydays.php?type="+usertype+"&id="+userid;

        Log.e("My Log", "getitinerary: URL: " + url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your itenrary are :" + response);

                try {

                    ItenraryResponseBean responseBean = ItenraryResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {
                            result.addAll(responseBean.results);

                            for(int i=0; i<result.size(); i++) {
                                String hotelVoucher1  =result.get(i).getDays().get(i).getHotel().get(i).getVoucherUrl().trim();
                                Log.e("mylog","MYHOTELVOUCHER"+ hotelVoucher1);
                                if(!hotelVoucher1.equals("")){
                                    WebSettings ws = m_webview.getSettings();
                                    ws.setDomStorageEnabled(true);
                                    ws.setJavaScriptEnabled(true);
                                    ws.setUseWideViewPort(true);
                                    ws.setLoadWithOverviewMode(true);
                                    m_webview.requestFocus();
                                    m_webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + hotelVoucher1);
                                }
                                else {
                                    Toast.makeText(HotelWeb.this, "No Document Available Now", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HotelWeb.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}