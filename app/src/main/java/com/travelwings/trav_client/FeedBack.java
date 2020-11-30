package com.travelwings.trav_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FeedBack extends AppCompatActivity {


    TextView m_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
       m_name=findViewById(R.id.name_FEED);
        Intent intent = getIntent();
       String name = intent.getStringExtra("feed");
        Log.e("mylog","feedback value is "+name);
        m_name.setText(name);
    }
}