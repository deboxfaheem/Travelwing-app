package com.travelwings.trav_client.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.Adapters.DocumentsAdapter;
import com.travelwings.trav_client.AppConstants.AppNetworkConstants;
import com.travelwings.trav_client.Models.ResultPasResponseBean;
import com.travelwings.trav_client.Models.Resultpas;
import com.travelwings.trav_client.R;
import com.travelwings.trav_client.WebServices;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentsFragment extends Fragment {

    WebServices webServices;

    private String userid;
    private String usertype;

    DocumentsAdapter documentsAdapter;
    public static ProgressBar progressBar;
     RecyclerView recyclerView;

    ArrayList<Resultpas> resultpasArrayList;
  //  FragmentManager fragmentManager;

    ImageView back_arrow;
    public DocumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_documents, container, false);

        recyclerView=view.findViewById(R.id.documents_recyclerview);
        back_arrow=view.findViewById(R.id.back_icon);
        progressBar=view.findViewById(R.id.progress_bar_document);
     //   fragmentManager=getActivity().getSupportFragmentManager();
        resultpasArrayList=new ArrayList<>();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);


      /*  webServices=(WebServices)getContext().getApplicationContext();

        webServices.Documentlist(getActivity(),getFragmentManager());*/

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();
            }
        });
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        documentsAdapter = new DocumentsAdapter(getActivity(), resultpasArrayList,getFragmentManager());

        recyclerView.setAdapter(documentsAdapter);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

        userid = sharedPreferences.getString("id", "");
        usertype = sharedPreferences.getString("type", "");

       getDoucment();

        return view;
    }


   public void getDoucment(){

     //  String document_url="http://deboxglobal.co.in/travcrm-latestinbound/api/json_documentdetails.php?id=671&type=2";
       String document_url= AppNetworkConstants.PERSONALDOCUMENT +"type="+usertype+"&id="+userid;
       Log.e("mylog","MYDOCUMENTAPI"+document_url);
       StringRequest stringRequest = new StringRequest(Request.Method.POST, document_url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {

               Log.e("mylog", response);
               //hiding the progressbar after completion
                 progressBar.setVisibility(View.INVISIBLE);

           //    DocumentsFragment.progressBar.setVisibility(View.GONE);
               try
               {
                   ResultPasResponseBean responseBean = ResultPasResponseBean.fromJson(response);
                   if (responseBean != null) {
                       if (responseBean.status.equals("true")) {
                           resultpasArrayList.addAll(responseBean.results);
                           documentsAdapter.notifyDataSetChanged();

                       }
                   }


                   Log.d("mylog", "reachedBeforeAdapter");


                  // documentsAdapter.notifyDataSetChanged();

                   Log.e("mylog", "my resultpassarray is" + resultpasArrayList);

               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {


                       Log.d("mylog", "Error_volley");
                       if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                           Toast.makeText(getContext(),
                                   "no connection",
                                   Toast.LENGTH_LONG).show();
                       } else if (error instanceof AuthFailureError) {

                           Toast.makeText(getContext(),
                                   "Auth faliur",
                                   Toast.LENGTH_LONG).show();
                           //TODO
                       } else if (error instanceof ServerError) {

                           Toast.makeText(getContext(),
                                   "server error",
                                   Toast.LENGTH_LONG).show();
                           //TODO
                       } else if (error instanceof NetworkError) {

                           Toast.makeText(getContext(),
                                   "netrork error",
                                   Toast.LENGTH_LONG).show();
                           //TODO
                       } else if (error instanceof ParseError) {
                           Toast.makeText(getContext(),
                                   "parse error",
                                   Toast.LENGTH_LONG).show();
                           //displaying the error in toast if occurrs
                           // Log.d("mylog",error.getMessage().toString());
                           //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                       }


                   }


               });


       //creating a request queue
       RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
       requestQueue.add(stringRequest);

   }
}
