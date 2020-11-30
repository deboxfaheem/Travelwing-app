package com.travelwings.trav_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class VouchersAct extends AppCompatActivity {

    LinearLayout m_hotelvoucher,m_flightvoucher,m_insurance,m_finance,m_invoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouchers);

        m_hotelvoucher=findViewById(R.id.ll_hotel_VOC);
        m_flightvoucher=findViewById(R.id.ll_flight_VOC);
        m_insurance=findViewById(R.id.ll_insurance_VOC);
        m_finance=findViewById(R.id.ll_finance_VOC);
        m_invoice=findViewById(R.id.ll_invoice_VOC);

       m_hotelvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(VouchersAct.this,HotelWeb.class);
                startActivity(i);
            }
        });

        m_flightvoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(VouchersAct.this,FlightWeb.class);
                startActivity(i);
            }
        });

        m_insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(VouchersAct.this,InsuranceWeb.class);
                startActivity(i);
            }
        });

        m_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(VouchersAct.this,FinacneActivity.class);
                startActivity(i);
            }
        });

        m_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(VouchersAct.this,InvoiceWeb.class);
                startActivity(i);
            }
        });
    }
}