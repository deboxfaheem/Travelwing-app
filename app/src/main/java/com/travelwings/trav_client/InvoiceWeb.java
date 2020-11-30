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
import com.travelwings.trav_client.Models.InvoucherModel;
import com.travelwings.trav_client.Models.InvoucherResponseBean;

import java.util.ArrayList;

public class InvoiceWeb extends AppCompatActivity {

    WebView m_webview;
    private String userid;
    private String usertype;
    ArrayList<InvoucherModel> invoucherModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_web);

        m_webview = findViewById(R.id.trav_webview_WB);

        invoucherModels=new ArrayList<>();

        SharedPreferences sharedPreferences = InvoiceWeb.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");
        getInvoice();
    }

    public void getInvoice() {

        String url = AppNetworkConstants.INVOICEPDF +"type="+usertype+"&id="+userid;
       // final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_invoicepdf.php?id="+userid+"&type="+usertype;

        Log.e("My Log", "getitinerary: URL: " + url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your invoice are :" + response);

                try {

                   InvoucherResponseBean responseBean = InvoucherResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {
                            invoucherModels.addAll(responseBean.results);

                                String invoicePdfLink  =invoucherModels.get(0).getInvoicePdfLink();
                                Log.e("mylog","MYINVOICE"+ invoicePdfLink);

                                if(!invoicePdfLink.equals("")){
                                    WebSettings ws = m_webview.getSettings();
                                    ws.setDomStorageEnabled(true);
                                    ws.setJavaScriptEnabled(true);
                                    ws.setUseWideViewPort(true);
                                    ws.setLoadWithOverviewMode(true);
                                    m_webview.requestFocus();
                                  //  m_webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + invoicePdfLink);
                                    m_webview.loadUrl(invoicePdfLink);
                                }
                                else {
                                    Toast.makeText(InvoiceWeb.this, "No Document Available Now", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(InvoiceWeb.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}