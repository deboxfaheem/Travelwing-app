package com.travelwings.trav_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.travelwings.trav_client.Fragments.DocumentsFragment;

public class PersonalFrag extends AppCompatActivity {

    DocumentsFragment documentsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_frag);

        documentsFragment=new DocumentsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_pesonal_DOC, documentsFragment).commit();
    }
}