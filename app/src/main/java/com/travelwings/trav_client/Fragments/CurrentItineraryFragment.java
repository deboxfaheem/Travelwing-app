package com.travelwings.trav_client.Fragments;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.*;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.travelwings.trav_client.Adapters.IteAdapter;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.MainHomeActivity;
import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.ItenraryResponseBean;
import com.travelwings.trav_client.Models.Result;
import com.travelwings.trav_client.Models.ResultFeedResponseBean;
import com.travelwings.trav_client.Models.ResultResponseBean;
//import com.example.client_trav.MytripStorage;
import com.travelwings.trav_client.R;
import com.travelwings.trav_client.WebServices;
import com.travelwings.trav_client.rest.MyClickFeed;
import com.travelwings.trav_client.rest.MyClickTrip;
import com.travelwings.trav_client.rest.MyNavigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentItineraryFragment extends Fragment
implements MyClickFeed {

    Context context;

   String emojivalue="";
    // private RecyclerViewAdapter adapter;
    // RecAdapter recAdapter;
    IteAdapter iteAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
  //  private KmHeaderItemDecoration kmHeaderItemDecoration;
    WebServices webServices;
    ProgressBar progressBar;
    ImageView back;



   public BottomNavigationView bottomNavigationView;
    CurrentItineraryFragment currentItineraryFragment;
    Result results;
    String feedback=null;

    private boolean isFeedbackClicked = false;

    ArrayList<Result> result;
    //ArrayList<VoucherDatum> voucherData;
    ArrayList<ItenaryModel> itenaryModels = new ArrayList<>();
    MyNavigation myNavigation;

    MyClickTrip myClickTrip;
   TextView m_tripname;
   int pos=0;
    private String userid;
    private String usertype;


    public CurrentItineraryFragment() {
        // Required empty public constructor
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_itinerary, container, false);

        back = view.findViewById(R.id.back_icon);
        progressBar = view.findViewById(R.id.progress_bar_invoice);
        webServices = (WebServices) getContext().getApplicationContext();
        //   adapter = new RecyclerViewAdapter();
       m_tripname=view.findViewById(R.id.mytrip_ITE);

//        itenaryModels=new ArrayList<>();
        currentItineraryFragment=new CurrentItineraryFragment();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerItenery);


        bottomNavigationView=view.findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) getContext());

        bottomNavigationView.setItemIconTintList(null);

        Menu menu= bottomNavigationView.getMenu();
        MenuItem menuItemf= menu.getItem(0);
        menuItemf.setIcon(R.drawable.homegray);
       // bottomNavigationView.setVisibility(View.GONE);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");
      //  getitinerary();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, MainHomeActivity.class);
                        context.startActivity(intent);

              //  getActivity().onBackPressed();
            }
        });


        getLatIte();
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar.setVisibility(View.INVISIBLE);

        return view;
    }


    public void myDialogHappy()
    {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.happydialog);
        Button m_sad_btn=dialog.findViewById(R.id.submit_SAD);
        final TextView m_name_feed=dialog.findViewById(R.id.name_FEED);
        final ImageView m_cancel_feed=dialog.findViewById(R.id.cancel_DIALOG);
        m_name_feed.setText(feedback);
        final ImageView m_sad_gray=dialog.findViewById(R.id.sad_gray_emoji_ITE);
        final ImageView m_sad=dialog.findViewById(R.id.sad_emoji_ITE);
        final ImageView m_nuteral_gray=dialog.findViewById(R.id.nuteral_gray_emoji_ITE);
        final ImageView m_nuteral=dialog.findViewById(R.id.nuteral_emoji_ITE);
        final ImageView m_happy_gray=dialog.findViewById(R.id.happy_gray_emoji_ITE);
        final ImageView m_happy=dialog.findViewById(R.id.happy_emoji_ITE);

        //  Intent i=dial;

        dialog.setTitle("Custom Dialog");
        dialog.show();

        m_cancel_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });


            m_sad_gray.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isFeedbackClicked = true;
                    m_sad_gray.setVisibility(View.GONE);
                    m_sad.setVisibility(View.VISIBLE);
                    m_nuteral_gray.setVisibility(View.VISIBLE);
                    m_nuteral.setVisibility(View.GONE);
                    m_happy_gray.setVisibility(View.VISIBLE);
                    m_happy.setVisibility(View.GONE);
                    m_name_feed.setVisibility(View.VISIBLE);
                    emojivalue = "1";

                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

                    userid = sharedPreferences.getString("id", "");
                    usertype = sharedPreferences.getString("type", "");

                    //getFeedback();
                }
            });

            m_nuteral_gray.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isFeedbackClicked = true;
                    m_nuteral_gray.setVisibility(View.GONE);
                    m_nuteral.setVisibility(View.VISIBLE);
                    m_sad_gray.setVisibility(View.VISIBLE);
                    m_sad.setVisibility(View.GONE);
                    m_happy_gray.setVisibility(View.VISIBLE);
                    m_happy.setVisibility(View.GONE);
                    m_name_feed.setVisibility(View.VISIBLE);
                    emojivalue = "2";

                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

                    userid = sharedPreferences.getString("id", "");
                    usertype = sharedPreferences.getString("type", "");
                    // getFeedback();
                }
            });

            m_happy_gray.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isFeedbackClicked = true;
                    m_happy_gray.setVisibility(View.GONE);
                    m_happy.setVisibility(View.VISIBLE);
                    m_nuteral_gray.setVisibility(View.VISIBLE);
                    m_nuteral.setVisibility(View.GONE);
                    m_sad_gray.setVisibility(View.VISIBLE);
                    m_sad.setVisibility(View.GONE);
                    m_name_feed.setVisibility(View.VISIBLE);
                    emojivalue = "3";

                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

                    userid = sharedPreferences.getString("id", "");
                    usertype = sharedPreferences.getString("type", "");
                    //  getFeedback();
                }
            });


        m_sad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFeedbackClicked==true) {
                    getFeedback();
                    Toast.makeText(dialog.getContext(), "Submitted", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(dialog.getContext(), "Please first select one feedback!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    public void getLatIte() {

        //result = new ArrayList<>();

   //  String url="http://tw-worldwideholidays.com/live/api/json_itenerarydays.php?type=2&id=5";
        String url="http://tw-worldwideholidays.com/live/api/json_itenerarydays.php?type="+usertype+"&id="+userid;

      //  String url = AppNetworkConstants.ITENERARY +"type="+usertype+"&id="+userid;
        Log.e("My Log", "getitinerary: URL: " + url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your itenrary are :" + response);
                progressBar.setVisibility(View.INVISIBLE);

                try {
                    ItenraryResponseBean responseBean = ItenraryResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {
                            itenaryModels.clear();
                            itenaryModels.addAll(responseBean.results);

                            Log.e("MyLog", "itenaryModels.size(): " + itenaryModels.size()
                                    +", itenaryModels.get(0).getDays().size(): " + itenaryModels.get(0).getDays().size());
//                            for (DayModel day: itenaryModels.get(pos).getDays()) {
//                                Log.e("MyLog", "onResponse: Day No.: " + day.getDay());
//                            }

                            if(itenaryModels.size()>0 && itenaryModels.get(0).getDays().size()>0)
                            {
                                iteAdapter = new IteAdapter(getActivity(), CurrentItineraryFragment.this, itenaryModels.get(0).getDays(), feedback);
                                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                                recyclerView.setAdapter(iteAdapter);
//                                if (itenaryModels.size() > 0 && itenaryModels.get(0) != null) {
//                                }
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                            else {
                                recyclerView.setVisibility(View.GONE);
                            }


                            for(int i=0; i<itenaryModels.size(); i++) {
                                String trip = itenaryModels.get(i).getSubject();
                                m_tripname.setText(trip);
                            }
                            //    myClickTrip.onDemoClick(result,pos);

                        }
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }



                Log.e("mylog", "my result is" + result);
                //  Log.e("mylog", "my voucher is" + voucherData);
                Log.e("mylog", "my feedback is" + feedback);


                //  iteAdapter = new IteAdapter(context, result, voucherData,feedback);

                //   recyclerView.setAdapter(iteAdapter);
                //     iteAdapter.notifyDataSetChanged();*/


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "No Internet Connection", Toast.LENGTH_LONG).show();

            }
        })
        {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("id",userid );
                params.put("type", usertype);

                Log.e("Mylog", "USER ID " + userid);
                Log.e("Mylog", "USER TYPE " + usertype);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }






    public void getitinerary() {

        result = new ArrayList<>();
        //voucherData = new ArrayList<>();
        //itenrarays = new ArrayList<>();
       // final MytripStorage mystorage = new MytripStorage();



        progressBar.setVisibility(View.INVISIBLE);
//        iteAdapter = new IteAdapter(getActivity(), this, itenaryModels,feedback);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.setAdapter(iteAdapter);

       // final String url =  "http://deboxglobal.co.in/travcrm-latestinbound/api/json_itenerarydays.php?id=671&type=2";
      //  final String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_itenerarydays.php?type="+usertype+"&id="+userid;
        String url = AppNetworkConstants.ITENERARY +"type="+usertype+"&id="+userid;
        Log.e("My Log", "getitinerary: URL: " + url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your itenrary are :" + response);
                progressBar.setVisibility(View.INVISIBLE);

                try {

                    ResultResponseBean responseBean = ResultResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {
                            result.addAll(responseBean.results);


                            for(int i=0; i<result.size(); i++) {
                                String trip = result.get(i).getTripName();
                                m_tripname.setText(trip);
                            }
                        //    myClickTrip.onDemoClick(result,pos);
                        }
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }



                Log.e("mylog", "my result is" + result);
              //  Log.e("mylog", "my voucher is" + voucherData);
                Log.e("mylog", "my feedback is" + feedback);

               RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);

               //  iteAdapter = new IteAdapter(context, result, voucherData,feedback);

             //   recyclerView.setAdapter(iteAdapter);
           //     iteAdapter.notifyDataSetChanged();*/


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })
        {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("id",userid );
                params.put("type", usertype);

                Log.e("Mylog", "USER ID " + userid);
                Log.e("Mylog", "USER TYPE " + usertype);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }


    public void getFeedback() {

        String url = AppNetworkConstants.CLIENTFEEDBACK +"type="+usertype+"&id="+userid;
       // String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientfeedback.php?type="+usertype+"&id="+userid; //&rating=1&experience=good&images=xyz.jpg";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your feedback are :" + response);
                progressBar.setVisibility(View.INVISIBLE);

                try {

                    ResultFeedResponseBean responseBean = ResultFeedResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if ("true".equals(responseBean.response.success)) {
                            feedback = responseBean.response.msg;
                            Log.e("mylog", "your feedback after respose are :" + feedback);
                            Log.e("MyLog", "onResponse: itenaryModels.size(): " + itenaryModels.size());
                            iteAdapter = new IteAdapter(getActivity(), CurrentItineraryFragment.this, itenaryModels.get(0).getDays(), feedback);

                            recyclerView.setAdapter(iteAdapter);

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
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();

            }
        }) {
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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();
        }

    @Override
    public void onFeedClick(String feed) {
        Log.e("Testing", "onFeedClick: Feedback from Adapter: " +  feedback );
        myDialogHappy();
    }
}
