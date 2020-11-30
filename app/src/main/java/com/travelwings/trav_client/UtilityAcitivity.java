package com.travelwings.trav_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.travelwings.trav_client.Fragments.WeatherFragment;

public class UtilityAcitivity extends AppCompatActivity {

    LinearLayout m_currency,m_weather;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility_acitivity);
        frameLayout=findViewById(R.id.frameconatiner);

        m_currency = findViewById(R.id.ll_currency_UTI);
        m_weather = findViewById(R.id.ll_weather_UTI);

        m_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UtilityAcitivity.this,CurrencyActivity.class);
                startActivity(i);

            }
        });

        m_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.frameconatiner, new WeatherFragment()).commit();
                frameLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}