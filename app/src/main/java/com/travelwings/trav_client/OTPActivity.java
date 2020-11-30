package com.travelwings.trav_client;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.ResendResponseBean;
import com.goodiebag.pinview.Pinview;

public class OTPActivity extends AppCompatActivity {

    Button verify_otp;
    Pinview pinview;
    String otp;
    LinearLayout otp_linear;
    TextView m_resend;

    private String userid;
    private String usertype;
    private String userotp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        pinview=findViewById(R.id.pinview);
        verify_otp=findViewById(R.id.getotp);
        otp_linear=findViewById(R.id.linear_otp);
        m_resend=findViewById(R.id.resend_otp);

        verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                {
                    //email_var = et_email.getText().toString();
                    otp = pinview.getValue().toString();


                    if (TextUtils.isEmpty(otp)) {

                        Snackbar snackbar = Snackbar.make(otp_linear, "Please fill PIN", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }

                    else
                    {

                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);
                        String share_otp = sharedPreferences.getString("otp", "");
                        String final_mob = sharedPreferences.getString("mobile", "");
                        String final_id =sharedPreferences.getString("id","");
                        String final_type =sharedPreferences.getString("type","");
                        String finalotpdummy=sharedPreferences.getString("otpdummy","");

                        if (otp.equals(share_otp)) {

                            SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences1.edit();
                            //   editor.putBoolean("login_state",loginstate);
                            editor.putString("mobile", final_mob);
                            editor.putString("type", final_type);
                            editor.putString("id", final_id);
                            editor.putString("otp", otp);
                            editor.commit();


                            //      Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                            Intent tomain = new Intent(getApplicationContext(), MainHomeActivity.class);
                            startActivity(tomain);
                            finish();

                        }
                        else if(otp.equals(finalotpdummy))
                        {

                            SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences1.edit();
                            //   editor.putBoolean("login_state",loginstate);
                            editor.putString("mobile", final_mob);
                            editor.putString("id", final_id);
                            editor.putString("otp", otp);
                            editor.putString("type",final_type );
                            editor.commit();

                            Intent tomain = new Intent(getApplicationContext(), MainHomeActivity.class);
                            startActivity(tomain);

                        //    finish();

                        }

                        else {

                            for (int i = 0;i < pinview.getPinLength();i++) {
                                pinview.onKey(pinview.getFocusedChild(), KeyEvent.KEYCODE_DEL, new KeyEvent(KeyEvent.ACTION_UP,KeyEvent.KEYCODE_DEL));
                            }
                            Snackbar snackbar = Snackbar
                                    .make(otp_linear, "Invalid PIN", Snackbar.LENGTH_LONG);
                            snackbar.show();

                        }

                    }


                }



            }
        });

        SharedPreferences sharedPreferences = OTPActivity.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");
        userotp = sharedPreferences.getString("otp", "");

        m_resend.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {


          myResent();
      }
  });
    }

   public void myResent(){
       String url = AppNetworkConstants.FORGOT + "id="+userid;
       Log.e("mylog", "your URL of resend otp :" + url);
       StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               Log.e("mylog", "your Resend OTP are :" + response);
               try {

                   ResendResponseBean responseBean = ResendResponseBean.fromJson(response);
                   if (responseBean != null) {
                       if ("true".equals(responseBean.status)) {
                         String myotp = responseBean.results.get(0).getOtp();
                           String myerror = responseBean.results.get(0).getError();

                           Log.e("MyLog", "MYOTP: " + myotp);
                           Log.e("MyLog", "MyERROR: " + myerror);
                           if(!userid.equals(""))
                           {
                               showNotification(userotp);
                               Toast.makeText(OTPActivity.this,userotp,Toast.LENGTH_SHORT).show();
                           }
                           else {

                               Toast.makeText(OTPActivity.this,myerror,Toast.LENGTH_SHORT).show();
                           }
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
               Toast.makeText(OTPActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

           }
       }) {
       };

       RequestQueue requestQueue = Volley.newRequestQueue(this);
       requestQueue.add(stringRequest);
   }

    private void showNotification(String otp) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        String description = "Your Travelwing login OTP: " + otp;

        Log.e("mylog","MY OTP Descritpion "+description);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "OTP_NOTIFICATION")
                .setSmallIcon(R.drawable.ic_launcher_background)
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
}
