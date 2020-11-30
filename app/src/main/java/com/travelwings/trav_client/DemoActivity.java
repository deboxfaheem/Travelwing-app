package com.travelwings.trav_client;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.travelwings.trav_client.Models.ResultFeedResponseBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zfdang.multiple_images_selector.ImagesSelectorActivity;
import com.zfdang.multiple_images_selector.SelectorSettings;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 732;

    String images="";

    private TextView tvResults;
    private ArrayList<String> mResults = new ArrayList<>();
    SharedPreferences sharedPreferences;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Window window = this.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        }



        Button bt = (Button) findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start multiple photos selector
                Intent intent = new Intent(DemoActivity.this, ImagesSelectorActivity.class);
                // max number of images to be selected
                intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 1);
                // min size of image which will be shown; to filter tiny images (mainly icons)
                intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 5000);
                // show camera or not
                intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                // pass current selected images as the initial value
                intent.putExtra(SelectorSettings.SELECTOR_INITIAL_SELECTED_LIST, images);
                // start the selector
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.results_recycler);
      //  back_arrow=view.findViewById(R.id.back_icon);
       // progressBar=view.findViewById(R.id.progress_bar_document);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        showpictures();
        getFeedback();

    }

    private void showpictures() {


        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getSharedPreferences("savepic", Context.MODE_PRIVATE);

        String json = sharedPreferences.getString("picturesonly", "");
        if (json.isEmpty()) {
            Toast.makeText(DemoActivity.this,"No pictures to show...",Toast.LENGTH_LONG).show();
        } else {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            ArrayList<String> arrPackageData = gson.fromJson(json, type);
            ImageAdpater adapter = new ImageAdpater(getApplicationContext(), arrPackageData);
            //adding the adapter to listview
            recyclerView.setAdapter(adapter);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // get selected images from selector
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
                images=mResults.get(0);
                assert mResults != null;

                // show results in textview
             //   StringBuilder sb = new StringBuilder();
               // sb.append(String.format("Totally %d images selected:", mResults.size())).append("\n");
               // for(String result : mResults) {
                 //   sb.append(result).append("\n");
               // }
               // tvResults.setText(sb.toString());


            //    save_User_To_Shared_Prefs(getApplicationContext(),mResults);
                SharedPreferences sharedPreferences = getSharedPreferences("savepic", Context.MODE_PRIVATE);

                sharedPreferences.edit().clear();

                savepictures(mResults);

                ImageAdpater adapter = new ImageAdpater(getApplicationContext(), mResults);
                //adding the adapter to listview
                recyclerView.setAdapter(adapter);


            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void savepictures(ArrayList<String> mResults) {

      //  String nameData = name.getText().toString().trim();
        //String addressData = address.getText().toString().trim();
        //arrPackage.add(nameData);
       // arrPackage.add(addressData);
        Gson gson = new Gson();
        String json = gson.toJson(mResults);
        SharedPreferences sharedPreferences=getSharedPreferences("savepic",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("picturesonly",json );
        images=json;
        editor.commit();
    }


    public static void save_User_To_Shared_Prefs(Context context, ArrayList<String> _USER) {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(_USER);
        prefsEditor.putString("pictures", json);
        prefsEditor.commit();

    }

    public void getFeedback(){

        String url = "http://deboxglobal.co.in/travcrm-latestinbound/api/json_clientfeedback.php?id=671&type=2";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your Images are :" + response);

                try {
                    requestQueue.getCache().clear();
                    ResultFeedResponseBean responseBean = ResultFeedResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if ("true".equals(responseBean.response.success)) {
                            Toast.makeText(DemoActivity.this,responseBean.response.msg,Toast.LENGTH_SHORT).show();
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
                Toast.makeText(DemoActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("images", images);

                Log.e("Mylog", "IMAGES " +images);

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
