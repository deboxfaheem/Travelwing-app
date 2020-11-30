package com.travelwings.trav_client;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.FinanceModel;
import com.travelwings.trav_client.Models.FinanceResponseBean;

import java.util.ArrayList;

public class FinacneActivity extends AppCompatActivity {

    TextView m_total, m_recieved, m_pending, m_query;

    private String userid;
    private String usertype;
    ArrayList<FinanceModel> financeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finacne);

        m_total=findViewById(R.id.total_FIN);
        m_pending=findViewById(R.id.pending_FIN);
        m_query=findViewById(R.id.query_FIN);
        m_recieved=findViewById(R.id.received_FIN);

      financeModels=new ArrayList<>();
        SharedPreferences sharedPreferences = FinacneActivity.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");

        getFinance();
    }


    public void getFinance(){

        String url = AppNetworkConstants.CLIENTPAYMENT +"type="+usertype+"&id="+userid;
        //String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientPayment.php?type="+usertype+"&id="+userid;

        Log.e("mylog","MYFINANCE"+url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your Finance are :" + response);

                try {
                    FinanceResponseBean responseBean = FinanceResponseBean.fromJson(response);
                    if (responseBean != null) {

                        if (responseBean.status.equals("true")) {
                            financeModels.addAll(responseBean.results);

                            String total =financeModels.get(0).getTotalClientCost();
                            String received =financeModels.get(0).getReceived();
                            String pendingCost =financeModels.get(0).getPendingCost();
                            String queryid =financeModels.get(0).getTripId();

                            m_total.setText(total);
                            m_pending.setText(pendingCost);
                            m_recieved.setText(received);
                            m_query.setText(queryid);
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
                Toast.makeText(FinacneActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}