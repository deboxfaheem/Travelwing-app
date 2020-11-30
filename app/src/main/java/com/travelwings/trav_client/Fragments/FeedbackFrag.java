package com.travelwings.trav_client.Fragments;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Button;


import com.travelwings.trav_client.R;
import com.travelwings.trav_client.VolleyMultipart;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFrag extends Fragment {


    LinearLayout ratings,experience,pics;
    ImageView icon;
    String experiance="";
    public FeedbackFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_feedback, container, false);

        ratings=view.findViewById(R.id.ratings);
        experience=view.findViewById(R.id.experience);
        pics=view.findViewById(R.id.pictures);
        icon=view.findViewById(R.id.back_icon);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        ratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.main_container, new RatingFragment()).addToBackStack("hdgh").commit();
            }
        });


        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.main_container, new ExperienceFragment()).addToBackStack("hdgh").commit();

            }
        });
        pics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), VolleyMultipart.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void opendialogbox() {


                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dlg_feedback);
                dialog.setCanceledOnTouchOutside(true);

        EditText editText=dialog.findViewById(R.id.review_box_feedback);
          experiance= editText.getText().toString().trim();
        Log.e("Mylog", "Experience TextView " + experiance);
        Button submit=dialog.findViewById(R.id.submitreview);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.document_details_background);
                //  dialog.getWindow().setBackgroundDrawableResource(R.drawable.document_details_background);

                dialog.show();

    }

}
