package com.travelwings.trav_client;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.Adapters.DocTripAdapter;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.TripModel;
import com.travelwings.trav_client.Models.TripResponseBean;

import java.util.ArrayList;

public class DocTrip extends AppCompatActivity {

    RecyclerView m_rec;
    ArrayList<TripModel> tripModels;
    DocTripAdapter docTripAdapter;
    private String userid;
    private String usertype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_trip);
        m_rec=findViewById(R.id.recycler_tripdoc);
       tripModels=new ArrayList<>();

        SharedPreferences sharedPreferences = DocTrip.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");

      getDocTrip();
    }

    public void getDocTrip(){

      //  String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_doctravel.php?id=671&type=2";

        String url = AppNetworkConstants.DOCTRAVEL +"type="+usertype+"&id="+userid;

        Log.e("mylog","MYDOCUMENTAPITRAV"+url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your trip documents are :" + response);

                try {
                    TripResponseBean responseBean = TripResponseBean.fromJson(response);
                    if (responseBean != null) {

                        if (responseBean.status.equals("true")) {
                            tripModels.addAll(responseBean.results);

                            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(DocTrip.this,RecyclerView.VERTICAL, false);
                            m_rec.setLayoutManager(linearLayoutManager);
                            docTripAdapter=new DocTripAdapter(DocTrip.this,tripModels);
                            m_rec.setAdapter(docTripAdapter);
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
                Toast.makeText(DocTrip.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}