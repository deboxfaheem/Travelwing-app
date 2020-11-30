package com.travelwings.trav_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DocumentsActivity extends AppCompatActivity {

    LinearLayout m_pesonal,m_travels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);
        m_pesonal = findViewById(R.id.ll_personal_DOC);
        m_travels = findViewById(R.id.ll_travels_DOC);

        m_pesonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DocumentsActivity.this,PersonalFrag.class);
                startActivity(i);

            }
        });

        m_travels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(DocumentsActivity.this,DocTrip.class);
                        startActivity(i);
            }
        });

    }
}