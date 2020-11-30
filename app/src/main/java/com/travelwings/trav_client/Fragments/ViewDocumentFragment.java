package com.travelwings.trav_client.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.travelwings.trav_client.ImageAdpater;
//import com.example.client_trav.Models.DocumentModel;
import com.travelwings.trav_client.Models.Resultpas;
import com.travelwings.trav_client.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zfdang.multiple_images_selector.ImagesSelectorActivity;
import com.zfdang.multiple_images_selector.SelectorSettings;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewDocumentFragment extends Fragment {




    public ViewDocumentFragment() {
        // Required empty public constructor
    }

    private static final int REQUEST_CODE = 732;

    private TextView tvResults;
    private ArrayList<String> mResults = new ArrayList<>();
    private ArrayList<Resultpas> docs = new ArrayList<>();


    TextView adddoc,title;
    ImageView imageView,imageView2;
    RecyclerView recyclerView;
    int index;
    ImageView back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_view_document, container, false);


        adddoc=view.findViewById(R.id.clicktoadd);
        title=view.findViewById(R.id.title_doc);
        String value = getArguments().getString("title");
   //  index= getArguments().getInt("index");


        ArrayList<Resultpas> transactionList = (ArrayList<Resultpas>) getArguments().getSerializable("key");

        title.setText(value);
        back=view.findViewById(R.id.back_icon);
        recyclerView=view.findViewById(R.id.recycler_doc);
        //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
       // savedocs(transactionList);
        showpictures(index,transactionList);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();
            }
        });






        adddoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        // start multiple photos selector
                        Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
                        // max number of images to be selected
                        intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 3);
                        // min size of image which will be shown; to filter tiny images (mainly icons)
                        intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                        // show camera or not
                        intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                        // pass current selected images as the initial value
                        intent.putStringArrayListExtra(SelectorSettings.SELECTOR_INITIAL_SELECTED_LIST, mResults);
                        // start the selector
                        startActivityForResult(intent, REQUEST_CODE);
                    }



        });



        return view;
    }



    private void showpictures(int index, ArrayList<Resultpas> transactionList2) {


        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("savedoc"+ this.index, Context.MODE_PRIVATE);

        String json = sharedPreferences.getString("picturesonly", "");
        if (json.isEmpty()) {
            Toast.makeText(getActivity(),"No pictures to show...",Toast.LENGTH_LONG).show();
        } else {
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            ArrayList<String> arrPackageData = gson.fromJson(json, type);
            ImageAdpater adapter = new ImageAdpater(getActivity(), arrPackageData);
            //adding the adapter to listview
            recyclerView.setAdapter(adapter);
          //  transactionList2.get(index).setIsdoc(true);


        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // get selected images from selector
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
                assert mResults != null;

                // show results in textview
                //   StringBuilder sb = new StringBuilder();
                // sb.append(String.format("Totally %d images selected:", mResults.size())).append("\n");
                // for(String result : mResults) {/
                //   sb.append(result).append("\n");
                // }
                // tvResults.setText(sb.toString());


                //    save_User_To_Shared_Prefs(getApplicationContext(),mResults);

                SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("savedoc"+index, Context.MODE_PRIVATE);
                sharedPreferences2.edit().clear();
                savepictures(mResults);

                SharedPreferences.Editor editor = getActivity().getSharedPreferences("docs"+index, Context.MODE_PRIVATE).edit();
                editor.putBoolean("docu",true );
                editor.apply();

                ImageAdpater adapter = new ImageAdpater(getActivity(), mResults);
                //adding the adapter to listview
                recyclerView.setAdapter(adapter);

                Toast.makeText(getActivity(), "Uploaded Successfully", Toast.LENGTH_SHORT).show();




                //  PreferenceManager preferenceManager = new PreferenceManager(getActivity());
               // preferenceManager.setIsLoggedIn(true);


            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void savepictures(ArrayList<String> mResults) {

        Gson gson = new Gson();
        String json = gson.toJson(mResults);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("savedoc"+index,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("picturesonly",json );
        editor.commit();
    }

    private void savedocs(ArrayList<Resultpas> docs) {

        Gson gson = new Gson();
        String json = gson.toJson(docs);
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("savedocument",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("doconly",json );
        editor.commit();
    }

}
