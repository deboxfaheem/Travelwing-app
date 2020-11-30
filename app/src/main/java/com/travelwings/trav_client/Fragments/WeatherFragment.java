package com.travelwings.trav_client.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.R;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class WeatherFragment extends Fragment {

    Calendar calendar = Calendar.getInstance();
    Date day= calendar.getTime();
    long date = System.currentTimeMillis();
    Spinner m_spinner;
    TextView m_day, m_time,m_city,m_temp;
    String cityname;
    EditText m_edit_search;
    Button m_btn_search;

//    String cityarr[]={"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar","Chandigarh", "Chhattisgarh", "Daman and Diu", "Delhi", "Goa", "Gujarat","Haryana","Himachal Pradesh",
//            "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland",
//            "Odisha","Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh",
//            "Uttarakhand","West Bengal"};


    public WeatherFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_weather, container, false);

        m_day=view.findViewById(R.id.day_WEATHER);
        m_time=view.findViewById(R.id.time_WEATHER);
        m_city=view.findViewById(R.id.city_WEATHER);
        m_temp=view.findViewById(R.id.temprature_WEATHER);

        m_edit_search=view.findViewById(R.id.edit_search_WEATHER);
        m_btn_search=view.findViewById(R.id.btn_WEATHER);
     //   m_spinner = (Spinner) view.findViewById(R.id.spinner);

        SimpleDateFormat sdf = new SimpleDateFormat(" h:mm a");

        String sdf1 = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(day.getTime());
        String dateString = sdf.format(date);
        m_day.setText(dateString);
        m_time.setText(sdf1);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

       /* ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,cityarr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m_spinner.setAdapter(adapter);

        m_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cityname= parent.getItemAtPosition(position).toString();
                getWeather();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        m_btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityname=m_edit_search.getText().toString().trim();
                getWeather();
            }
        });


        getWeather();
        return view;
    }


    public void getWeather() {

        final String url= "http://api.openweathermap.org/data/2.5/weather?q="+cityname+"&appid=afc979012fee64bf8f3467f54b53bfea";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your weather Report are :" + response);


                try {
                    JSONObject obj = new JSONObject(response);
                    String city_name= obj.getString("name");
                    Log.e("MyLog", "MYCITYNAME: " + city_name);

                    JSONObject obj1 =(JSONObject) obj.getJSONObject("main");
                    String temp= obj1.getString("temp");
                    Log.e("MyLog", "MYCITYTEMP: " + temp);
                    double tempoduoble =Double.parseDouble(temp);


                    double temperatureCelsius = tempoduoble - 273.15;
                    String stringdouble= Double.toString(temperatureCelsius);


                    m_city.setText(city_name);

                    m_temp.setText(stringdouble);

                } catch (Exception e) {
                    e.printStackTrace();
                    //   Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //    Toast.makeText(WeatherActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("q",cityname);


                Log.e("Mylog", "parameter Location Name is " + cityname);


                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
   }