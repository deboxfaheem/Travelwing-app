package com.travelwings.trav_client;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.travelwings.trav_client.Models.LoginResponseBean;
import com.travelwings.trav_client.Models.TermModel;
import com.travelwings.trav_client.Models.TermResponseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText ed_mobile,nonedit;
    ProgressBar progressBar;
    ImageView btn_next;
    TextView m_register,m_terms,m_policy;
    ArrayList<TermModel> termModels;
    LinearLayout linearLayout;
    String mobile,type,id;
    String otp;
    int pos;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
  //  String url = "http://deboxcrm.com/crm/clientapp/client_login.php?mobile=9876543212";
  //  String url="http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientlogin.php?mobile=8130220538";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_mobile = findViewById(R.id.ed_mobile);
       // nonedit = findViewById(R.id.edit_startnumber);
        btn_next = findViewById(R.id.next_login);
        m_register = findViewById(R.id.register_LOGIN);
        m_terms = findViewById(R.id.terms_LOGIN);
        m_policy = findViewById(R.id.policy_LOGIN);


        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);

        termModels=new ArrayList<>();

        m_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intent=new Intent(LoginActivity.this,TermWebView.class);
           startActivity(intent);
            }
        });

        m_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,TermWebView.class);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Log.e("mylog", "mainactivity");

                    mobile = ed_mobile.getText().toString().trim();

                    if (mobile.length() != 10) {
                        ed_mobile.setError("Enter valid Number!");
                    }
                        else {

                        android.util.Patterns.PHONE.matcher(mobile).matches();
                        long SPLASH_TIME_OUT = 500;
                        new Handler().postDelayed(new Runnable() {
                            /*
                             * Showing splash screen with a timer. This will be useful when you
                             * want to show case your app logo / company
                             */

                            @Override
                            public void run() {

                                userLogin();
                            //    userRegisterFeedback();

                            }
                        }, SPLASH_TIME_OUT);

                     //   btn_next.setBackgroundResource(R.drawable.background_disabled);
     //                   progressBar.setVisibility(View.VISIBLE);
       //                 linearLayout.setVisibility(View.VISIBLE);
                       // btn_next.setVisibility(View.GONE);
                    }


                }
        });

        m_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterLogin.class);
                startActivity(i);
            }
        });
    }


    public void userLogin(){

       // final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientlogin.php";
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest( Request.Method.POST, AppNetworkConstants.LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your LoginDetail are :" + response);
                try {
                    queue.getCache().clear();

                   LoginResponseBean responseBean = LoginResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {

                            otp=responseBean.results.get(pos).getOtp();
                            type=responseBean.results.get(pos).getType();
                            id=responseBean.results.get(pos).getId();

                            Log.e("mylog","LOGIN TYPE is" +type);
                            Log.e("mylog","LOGIN ID is" +id);

                          //  String mobile1=responseBean.results.get(pos).getMobile();
                            String error=responseBean.results.get(pos).getError();
                            String mob=responseBean.results.get(pos).getMobile();



                            if(mob!=null)
                            {
                                Intent i = new Intent(getApplicationContext(), OTPActivity.class);
                                startActivity(i);
                                finish();
                                Toast.makeText(LoginActivity.this, otp, Toast.LENGTH_SHORT).show();
                                showNotification(otp);

                            }else{
                                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
                            }


                             /* if(error!=null && error.equalsIgnoreCase("Mobile number doesn’t exists"))
                            {
                              //  m_error.setText(error);
                                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
                            }*/
                            SharedPreferences sharedPreferences = getApplication().getSharedPreferences("login_client", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("mobile", mobile);
                            editor.putString("otp", otp);
                            editor.putString("type", type);
                            editor.putString("id", id);
                           // editor.putString("otpdummy", "4988");

                            Log.e("mylog","SHaredLOGIN TYPE is" +type);
                            Log.e("mylog","SharedLOGIN ID is" +id);
                            editor.commit();
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
                Toast.makeText(LoginActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();

            }
        })


        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();


                params.put("mobile",mobile);


                Log.e("Mylog", "parameter Moblie Number is " + mobile);
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

    private void showNotification(String otp) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        String description = "Your Travelwing login OTP: " + otp;

        Log.e("mylog","MY OTP Descritpion "+description);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "OTP_NOTIFICATION")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Travelwing")
                    .setContentText(description)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    // Set the intent that will fire when the user taps the notification
//                    .setContentIntent(pendingIntent)
                    .setAutoCancel(false);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
            notificationManager.notify(123, builder.build());
//        }
    }


    public void userTerm(){

        final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_mobileterms.php";
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your LoginDetail are :" + response);
                try {
                    TermResponseBean responseBean = TermResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {
                          //  =responseBean.results.get(0).getTermscondition();
                        //    termModels.addAll(responseBean.results);
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
                Toast.makeText(LoginActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();

            }
        });
        queue.add(stringRequest);
        queue.getCache().clear();
    }

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this, new String[] { permission }, requestCode);
        }
        else {
          //  Toast.makeText(LoginActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
    }
