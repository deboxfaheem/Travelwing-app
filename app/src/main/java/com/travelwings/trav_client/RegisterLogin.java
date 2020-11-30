package com.travelwings.trav_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.travelwings.trav_client.Models.SignupModel;
import com.travelwings.trav_client.Models.SignupResponseBean;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegisterLogin extends AppCompatActivity {

    private static final String TAG = RegisterLogin.class.getSimpleName();
    private String firstName, lastName, phoneNo, email,submit;
    int pos;
    SignupModel signupModels;

    public static String convertStandardJSONString(String data_json) {
        data_json = data_json.replaceAll("\\\\r\\\\n", "");
        data_json = data_json.replace("\"{", "{");
        data_json = data_json.replace("}\",", "},");
        data_json = data_json.replace("}\"", "}");
        return data_json;
    }

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "[_A-Za-z0-9-]+" +
            "(\\.[_A-Za-z0-9-]" +
            "+)*@[A-Za-z0-9]" +
            "+(\\.[A-Za-z0-9]" +
            "+)*(\\.[A-Za-z]{2,})$");

    ImageView m_icon;
    EditText m_first, m_last, m_mobile, m_email;
    TextView m_emailcheck;
    Button m_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);
        m_first = findViewById(R.id.firstname_REG);
        m_last = findViewById(R.id.lastname_REG);
        m_mobile = findViewById(R.id.mobile_REG);
        m_email = findViewById(R.id.email_REG);
        m_emailcheck = findViewById(R.id.emailcheck_REG);
        m_icon = findViewById(R.id.icon_REG);
        m_btn = findViewById(R.id.btn_REG);
        m_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterLogin.this, LoginActivity.class);
                startActivity(i);
            }
        });

        m_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regFrom();
            }
        });

    }

    public void regFrom() {
        firstName = m_first.getText().toString().trim();
        lastName = m_last.getText().toString().trim();
        phoneNo = m_mobile.getText().toString().trim();
        email = m_email.getText().toString().trim();

        if (firstName.equals("")) {
            m_first.setError("First name is not entered");
        } else if (lastName.equals("")) {
            m_last.setError("First name is not entered");
        } else if (phoneNo.isEmpty()) {
            m_mobile.setError("Mobile No is Empty");
        } else if (phoneNo.length() != 10) {
            m_mobile.setError("Mobile No is Not Valid");
        } else if (!PASSWORD_PATTERN.matcher(email).matches()) {
            m_email.setError("Email-ID is not Valid");
        } else {
           regDetail();
        }
    }

       public void regDetail() {
       // final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientregistration.php?register=submit";
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppNetworkConstants.REGISTRATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your RegistrationDetail are :" + response);
                try {
                    queue.getCache().clear();

                    SignupResponseBean responseBean = SignupResponseBean.fromJson(response);
                    if (responseBean != null) {
                        m_emailcheck.setText(responseBean.message);
                        if (responseBean.message.equalsIgnoreCase("Thank you registering with us, we will get back you shortly")) {
                            Intent i = new Intent(RegisterLogin.this, LoginActivity.class);
                            startActivity(i);
                            Toast.makeText(RegisterLogin.this, responseBean.message, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterLogin.this, responseBean.message, Toast.LENGTH_SHORT).show();
                        }
                        Log.e("MyLog", "MYMAILCHECK " + m_emailcheck);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterLogin.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })


        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("firstName",firstName);
                params.put("lastName",lastName);
                params.put("email",email);
                params.put("phoneNo",phoneNo);
              //  params.put("register",submit);

                Log.e("Mylog", "parameter fistName " + firstName);
                Log.e("Mylog", "parameter lastName " + lastName);
                Log.e("Mylog", "parameter email " + email);
                Log.e("Mylog", "parameter phoneNo " + phoneNo);
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