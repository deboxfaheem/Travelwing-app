package com.travelwings.trav_client.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.ResultFeedResponseBean;
import com.travelwings.trav_client.R;

import java.util.HashMap;
import java.util.Map;

public class ExperienceFragment extends Fragment {

    private String userid;
    private String usertype;

    EditText editText;
    Button submit;
    String experiance="";
    public ExperienceFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_experience, container, false);

         editText=view.findViewById(R.id.review_box_feedback);

         Log.e("Mylog", "Experience TextView " + experiance);
         submit=view.findViewById(R.id.submitreview);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                experiance= editText.getText().toString().trim();

                SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

                userid = sharedPreferences.getString("id", "");
                usertype = sharedPreferences.getString("type", "");
                getFeedback();
            }
        });

        return view;
    }

    public void getFeedback(){

      //  String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientfeedback.php?id=671&type=2";

      //  String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientfeedback.php?type="+usertype+"&id="+userid;
        String url = AppNetworkConstants.CLIENTFEEDBACK +"type="+usertype+"&id="+userid;
        Log.e("mylog", "MYEXPERIANCE IS :" + url);
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your feedback are :" + response);

                try {
                    requestQueue.getCache().clear();
                    ResultFeedResponseBean responseBean = ResultFeedResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if ("true".equals(responseBean.response.success)) {
                            Toast.makeText(getActivity(),responseBean.response.msg,Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("experience",experiance);

                Log.e("Mylog", "Experience " + experiance);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();
    }

}