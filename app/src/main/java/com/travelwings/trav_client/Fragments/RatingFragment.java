package com.travelwings.trav_client.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
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
//import com.yugansh.tyagi.smileyrating.SmileyRatingView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RatingFragment extends Fragment {

    private String userid;
    private String usertype;

  private boolean isFeedbackClicked = false;
  String emojivalue="";
    RatingBar ratingBar;
//    SmileyRatingView smileyRating;
    Button submit;
    RadioButton rb, rb2, rb3, rb4, rb5;
    RadioGroup radioGroup;
    ImageView back;
    public RatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rating, container, false);

        submit=view.findViewById(R.id.submit_emoji);
        back=view.findViewById(R.id.back_icon);
        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup1);
        rb = (RadioButton) view.findViewById(R.id.sad_emoji);
        rb2 = (RadioButton) view.findViewById(R.id.neutral_emoji);
        rb3 = (RadioButton) view.findViewById(R.id.happyemoji);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFeedbackClicked) {

                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

                    userid = sharedPreferences.getString("id", "");
                    usertype = sharedPreferences.getString("type", "");

                    getFeedback();
                    Toast.makeText(getContext(), "Submitted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Please first select one feedback!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent in;
                Log.i("matching", "matching inside1 bro" + checkedId);
                switch (checkedId) {

                    case R.id.sad_emoji:


                        rb.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sadred, 0, 0);
                        rb.setTextColor(getResources().getColor(R.color.transfer_color));
                        rb2.setBackground(getResources().getDrawable(R.drawable.emoji_background));
                        rb3.setBackground(getResources().getDrawable(R.drawable.emoji_background));

                        rb.setBackground(getResources().getDrawable(R.drawable.emoji_background_red));
                        rb2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.neutralgray, 0, 0);
                        rb2.setTextColor(getResources().getColor(R.color.Blackcolor2));
                        rb3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.happygray, 0, 0);
                        rb3.setTextColor(getResources().getColor(R.color.Blackcolor2));
                        isFeedbackClicked = true;
                        emojivalue="1";
                        break;


                    case R.id.neutral_emoji:
//                        Log.i("matching", "matching inside1 watchlistAdapter" + checkedId);
                        //  getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new QueryFragment(),"query").addToBackStack("query").commit();
                        rb2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.neutralyellow, 0, 0);
                        rb2.setTextColor(getResources().getColor(R.color.hotel_color));
                        rb.setBackground(getResources().getDrawable(R.drawable.emoji_background));
                        rb3.setBackground(getResources().getDrawable(R.drawable.emoji_background));

                        rb2.setBackground(getResources().getDrawable(R.drawable.emoji_background_yellow));
                        rb.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sadgray, 0, 0);
                        rb.setTextColor(getResources().getColor(R.color.Blackcolor2));
                        rb3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.happygray, 0, 0);
                        rb3.setTextColor(getResources().getColor(R.color.Blackcolor2));
                        isFeedbackClicked = true;
                        emojivalue="2";
                        break;


                    case R.id.happyemoji:

                      rb3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.happygreen, 0, 0);
                        rb3.setTextColor(getResources().getColor(R.color.sight_color));
                        rb.setBackground(getResources().getDrawable(R.drawable.emoji_background));
                        rb2.setBackground(getResources().getDrawable(R.drawable.emoji_background));

                        rb3.setBackground(getResources().getDrawable(R.drawable.emoji_background_green));

                        rb2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.neutralgray, 0, 0);
                        rb.setTextColor(getResources().getColor(R.color.Blackcolor2));
                        rb.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sadgray, 0, 0);
                        rb2.setTextColor(getResources().getColor(R.color.Blackcolor2));
                        //   FragmentManager fmm = getSupportFragmentManager();
                        isFeedbackClicked = true;
                        emojivalue="3";
                        break;

                }
            }
        });

        return view;
    }


    public void getFeedback(){

     //   String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientfeedback.php?id=671&type=2";

       // String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientfeedback.php?type="+usertype+"&id="+userid;

        String url = AppNetworkConstants.CLIENTFEEDBACK +"type="+usertype+"&id="+userid;
        Log.e("mylog", "MYRATINGFRAG :" + url);

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
                params.put("rating",emojivalue);
                Log.e("Mylog", "Emoji Values " + emojivalue);
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
