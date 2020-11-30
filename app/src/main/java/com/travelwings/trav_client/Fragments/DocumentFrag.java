package com.travelwings.trav_client.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.travelwings.trav_client.DocTrip;
import com.travelwings.trav_client.PersonalFrag;
import com.travelwings.trav_client.R;


public class DocumentFrag extends Fragment {

    LinearLayout m_pesonal,m_travels;
    public DocumentFrag() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_document, container, false);

        m_pesonal = view.findViewById(R.id.ll_personal_DOC);
        m_travels = view.findViewById(R.id.ll_travels_DOC);

        m_pesonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), PersonalFrag.class);
                startActivity(i);

            }
        });

        m_travels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getContext(), DocTrip.class);
                startActivity(i);
            }
        });


        return view;
    }
}