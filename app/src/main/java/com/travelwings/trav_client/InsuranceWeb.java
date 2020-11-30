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
import com.travelwings.trav_client.Models.InsuranceVoucherModel;
import com.travelwings.trav_client.Models.InsuranceVoucherResponseBean;

import java.util.ArrayList;

public class InsuranceWeb extends AppCompatActivity {

    private String userid;
    private String usertype;
    WebView m_webview;
    ArrayList<InsuranceVoucherModel> insuranceVoucherModels=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_web);

        m_webview = findViewById(R.id.trav_webview_WB);

        SharedPreferences sharedPreferences = InsuranceWeb.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");

        myVouvher();
    }

    public void myVouvher(){

      //  String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_insuranceVoucher.php?id=671&type=2";

      //  String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_insuranceVoucher.php?type="+usertype+"&id="+userid;
        String url = AppNetworkConstants.ISNSURANCEVOUCHER +"type="+usertype+"&id="+userid;

        Log.e("mylog", "MYINSURANCE :" + url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your Insurance Response :" + response);
                try {

                    InsuranceVoucherResponseBean responseBean = InsuranceVoucherResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true"))
                        {
                            insuranceVoucherModels.addAll(responseBean.results);

                            for(int i=0; i<insuranceVoucherModels.size(); i++) {
                                String insuranceVoucher1 = insuranceVoucherModels.get(i).getInsuranceVoucher().trim();
                                Log.e("mylog", "MYINSURANCEVOUCHER" + insuranceVoucher1);

                                if (!insuranceVoucher1.equals("")) {
                                    WebSettings ws = m_webview.getSettings();
                                    ws.setDomStorageEnabled(true);
                                    ws.setJavaScriptEnabled(true);
                                    ws.setUseWideViewPort(true);
                                    ws.setLoadWithOverviewMode(true);
                                    m_webview.requestFocus();
                                    m_webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + insuranceVoucher1);

                                } else {
                                    Toast.makeText(InsuranceWeb.this, "No Document Available Now", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(InsuranceWeb.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(InsuranceWeb.this);
        requestQueue.add(stringRequest);
    }

}