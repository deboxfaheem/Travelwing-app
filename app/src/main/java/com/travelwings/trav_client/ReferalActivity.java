package com.travelwings.trav_client;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.ReferResponseBean;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ReferalActivity extends AppCompatActivity {

    private String userid;
    private String usertype;

    String referralName,relation,city,phoneNo, profession,email,submit;
    EditText m_name,m_relation,m_mobile,m_city,m_profession,m_email;
    TextView m_submit;

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "[_A-Za-z0-9-]+" +
            "(\\.[_A-Za-z0-9-]" +
            "+)*@[A-Za-z0-9]" +
            "+(\\.[A-Za-z0-9]" +
            "+)*(\\.[A-Za-z]{2,})$");

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referal);

        back=findViewById(R.id.back_icon);
        m_name=findViewById(R.id.name_REFER);
        m_city=findViewById(R.id.city_REFER);
        m_email=findViewById(R.id.email_REFER);
        m_mobile=findViewById(R.id.mobile_REFER);
        m_profession=findViewById(R.id.profession_REFER);
        m_relation=findViewById(R.id.relation_REFER);
        m_submit=findViewById(R.id.submit_REFER);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               onBackPressed();


            }
        });

        m_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regFrom();
            }
        });


    }

    public void regFrom() {

        referralName= m_name.getText().toString().trim();
        city= m_city.getText().toString().trim();
        email= m_email.getText().toString().trim();
        phoneNo= m_mobile.getText().toString().trim();
        profession= m_profession.getText().toString().trim();
        relation= m_relation.getText().toString().trim();
        submit= m_submit.getText().toString().trim();

        if (referralName.equals("")) {
            m_name.setError("Refferal Name is not entered");
        } else if (city.equals("")) {
            m_city.setError("city is not entered");
        } else if (phoneNo.isEmpty()) {
            m_mobile.setError("Mobile No is Empty");
        } else if (phoneNo.length() != 10) {
            m_mobile.setError("Mobile No is Not Valid");
        } else if (!PASSWORD_PATTERN.matcher(email).matches()) {
            m_email.setError("Email-ID is not Valid");
        }
        else if (m_profession.equals("")) {
            m_profession.setError("Peofession is not Entered");
        }
        else {

            SharedPreferences sharedPreferences =ReferalActivity.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

            userid = sharedPreferences.getString("id", "");
            usertype = sharedPreferences.getString("type", "");
            regerEarn();
        }
    }


    public void regerEarn()
    {
       // final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_referfriend.php?refer=submit";

        Log.e("mylog", "MYREFERENCE :" + AppNetworkConstants.REFER);
        final RequestQueue queue = Volley.newRequestQueue(ReferalActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppNetworkConstants.REFER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your ReferEarn are :" + response);
                try {
                    queue.getCache().clear();

                    ReferResponseBean responseBean = ReferResponseBean.fromJson(response);
                    if (responseBean != null)
                    {
                        if (responseBean.message.equalsIgnoreCase("success")) {
                            Toast.makeText(ReferalActivity.this, responseBean.message, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ReferalActivity.this, "some error! please try again", Toast.LENGTH_SHORT).show();
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ReferalActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })


        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("referralName",referralName);
                params.put("city",city);
                params.put("email",email);
                params.put("phoneNo",phoneNo);
                params.put("relation",relation);
                params.put("profession",profession);
                //   params.put("refer",submit);


                Log.e("Mylog", "parameter RefferName " + referralName);
                Log.e("Mylog", "parameter Relation " + relation);
                Log.e("Mylog", "parameter Mobile Number " + phoneNo);
                Log.e("Mylog", "parameter Refer Button " + submit);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(stringRequest);
        queue.getCache().clear();
    }

}