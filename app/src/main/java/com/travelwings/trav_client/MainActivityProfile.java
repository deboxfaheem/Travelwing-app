package com.travelwings.trav_client;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.ProfileGetModel;
import com.travelwings.trav_client.Models.ProfileGetResponseBean;
import com.travelwings.trav_client.Models.ProfileResponseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivityProfile extends AppCompatActivity {
//    //  private static final String TAG = MainActivityProfile.class.getSimpleName();
//    public static final int REQUEST_IMAGE = 100;
//    // private static final LocalDate GlideApp = ;
    EditText m_id,m_firstname,m_lastname,m_birthDate,m_anniversary,m_address,m_email,m_mobile,m_accomodation,m_holiday,m_meal,m_special;
    Button m_submit;
    String id;
    String firstName,lastName,birthDate,anniversaryDate,address1,email,phoneNo;
    @BindView(R.id.img_profile)
    ImageView imgProfile;
    ImageView back;
    int pos;
    private String userid;
    private String usertype;
    ArrayList<ProfileGetModel> profileGetModels=new ArrayList<>();

    public static final String mypreference = "myupdatepreference";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        ButterKnife.bind(this);
        // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setTitle(null);
        back=findViewById(R.id.back_icon_PROFILE);
        m_id = findViewById(R.id.id_PROFILEU);
        m_firstname = findViewById(R.id.firstname_PROFILE);
        m_lastname = findViewById(R.id.lastname_PROFILEU);
        m_birthDate = findViewById(R.id.birth_PROFILEU);
        m_anniversary = findViewById(R.id.anniversery_PROFILEU);
        m_address = findViewById(R.id.address_PROFILE);
        m_email = findViewById(R.id.email_PROFILEU);
        m_mobile = findViewById(R.id.mobile_PROFILEU);
        m_accomodation = findViewById(R.id.accomodationpreference_PROFILEU);
        m_holiday = findViewById(R.id.holidaypreference_PROFILEU);
        m_meal = findViewById(R.id.mealPreference_PROFILEU);
        m_special = findViewById(R.id.specialassistance_PROFILEU);

        m_submit=findViewById(R.id.submit_PROFILEU);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SharedPreferences sharedPreferences = MainActivityProfile.this.getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");


        myProfileGet();

        m_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=m_id.getText().toString().trim();
                firstName=m_firstname.getText().toString().trim();
                lastName=m_lastname.getText().toString().trim();
                birthDate=m_birthDate.getText().toString().trim();
                anniversaryDate=m_anniversary.getText().toString().trim();
                address1=m_address.getText().toString().trim();
                email=m_email.getText().toString().trim();
                phoneNo=m_mobile.getText().toString().trim();

                myProfile();

            }
        });

    }


    public void myProfile(){

       // ?id=671&firstName=aamir&lastName=ahmed&birthDate=1994-12-23&anniversaryDate=2020-12-20&address1=saharanpur&email=aamirahmed620gmail.com&phoneNo=8130220538

       // final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_updateprofile.php";
        final RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppNetworkConstants.UPDATEPROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your My Profile Updated are :" + response);
                try {
                    queue.getCache().clear();

                    ProfileResponseBean responseBean= ProfileResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {

                            id=responseBean.results.get(pos).getId();
                            Intent i = new Intent(MainActivityProfile.this,UpdatedProfile.class);
                            startActivity(i);
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
                Toast.makeText(MainActivityProfile.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })


        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("id",id);
                params.put("firstName",firstName);
                params.put("lastName",lastName);
                params.put("birthDate",birthDate);
                params.put("anniversaryDate",anniversaryDate);
                params.put("address1",address1);
                params.put("email",email);
                params.put("phoneNo",phoneNo);

                Log.e("Mylog", "parameter ID Number is " + id);
                Log.e("Mylog", "parameter firstName is " + firstName);
                Log.e("Mylog", "parameter lastName is " + lastName);
                Log.e("Mylog", "parameter Country is " + birthDate);
                Log.e("Mylog", "parameter birthdate is " + birthDate);
                Log.e("Mylog", "parameter anniversary is " + anniversaryDate);
                Log.e("Mylog", "parameter address is " + address1);
                Log.e("Mylog", "parameter email is " + email);
                Log.e("Mylog", "parameter phoneno is " + phoneNo);

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

    public void myProfileGet(){

      //  String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientprofile.php?id=671";

        String url = AppNetworkConstants.CLIENTPROFILE + "id="+userid;

        Log.e("mylog", "MY UPDATED PROOFILE IS :" + url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your Profile Get Response are :" + response);
                try {

                    ProfileGetResponseBean responseBean = ProfileGetResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true"))
                        {
                           profileGetModels.addAll(responseBean.results);

                            String id1=responseBean.results.get(pos).getId();
                            String firstName1 =responseBean.results.get(pos).getFirstName();
                            String lastName1 =responseBean.results.get(pos).getLastName();
                           // String country1 =responseBean.results.get(pos).getCountry();
                            String mobile1 =responseBean.results.get(pos).getMobile();
                            String email1 =responseBean.results.get(pos).getEmail();
                            String dob1 =responseBean.results.get(pos).getDob();
                            String aniversary1 =responseBean.results.get(pos).getAnniversaryDate();
                            String address1 =responseBean.results.get(pos).getAddress();
                            String accomodation1 =responseBean.results.get(pos).getAccomodationpreference();
                            String holyday1=responseBean.results.get(pos).getHolidaypreference();
                            String meal1 =responseBean.results.get(pos).getMealPreference();
                            String special1 =responseBean.results.get(pos).getSpecialassistance();

                            m_firstname.setText(firstName1);
                            m_lastname.setText(lastName1);
                            m_mobile.setText(mobile1);
                            m_birthDate.setText(dob1);
                            m_email.setText(email1);
                            m_anniversary.setText(aniversary1);
                            m_address.setText(address1);
                            m_accomodation.setText(accomodation1);
                            m_holiday.setText(holyday1);
                            m_meal.setText(meal1);
                            m_special.setText(special1);
                            m_id.setText(id1);


                            SharedPreferences preferences = MainActivityProfile.this.getSharedPreferences("updateclient", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor =preferences.edit();
                            editor.putString("firstName1",firstName1);
                            editor.putString("lastName1",lastName1);
                            editor.putString("email1",email1);
                            editor.putString("mobile1",mobile1);

                            Log.e("mylog","SHared PROFILE UPDATE NAME is " +firstName1);
                            Log.e("mylog","SHared PROFILE UPDATE NAME is " +lastName1);
                            Log.e("mylog","Shared PROFILE UPDATE PHONE NO is " +mobile1);
                            editor.commit();

                          /* Intent i= new Intent(MainActivityProfile.this,MainHomeActivity.class);
                           i.putExtra("firstName1",firstName1);
                           i.putExtra("email1",email1);
                           i.putExtra("mobile1",mobile1);
                           startActivity(i);
*/

                            Log.e("mylog","First Name is " +m_firstname);
                            Log.e("mylog","last Name is " +m_lastname);
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
                Toast.makeText(MainActivityProfile.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivityProfile.this);
        requestQueue.add(stringRequest);
    }
}