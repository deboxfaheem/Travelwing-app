package com.travelwings.trav_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Pertrav extends AppCompatActivity {

    LinearLayout m_inter, m_domestic;
  //  LinearLayout m_hotelvoucher,m_flightvoucher,m_insurance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertrav);

        m_inter=findViewById(R.id.international_PETRAV);
        m_domestic=findViewById(R.id.domestic_PETRAV);
      /*  m_hotelvoucher=findViewById(R.id.ll_hotel_VOC);
        m_flightvoucher=findViewById(R.id.ll_flight_VOC);
        m_insurance=findViewById(R.id.ll_insurance_VOC);
*/
       /* m_hotelvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Pertrav.this,HotelWeb.class);
                startActivity(i);
            }
        });

        m_flightvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Pertrav.this,FlightWeb.class);
                startActivity(i);
            }
        });*/

        m_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Pertrav.this,TravelsWeb.class);
                startActivity(i);
            }
        });

        m_domestic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Pertrav.this,TravDomestic.class);
                startActivity(i);
            }
        });
      /*  m_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Pertrav.this,InsuranceWeb.class);
                startActivity(i);
            }
        });*/
    }
}