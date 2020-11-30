package com.travelwings.trav_client.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.travelwings.trav_client.Models.TripModel;
import com.travelwings.trav_client.R;
import com.travelwings.trav_client.VouchersAct;

import java.util.ArrayList;

public class DocTripAdapter extends RecyclerView.Adapter<DocTripAdapter.RecViewHolder> {

    Context context;
   ArrayList<TripModel> tripModels;

    public DocTripAdapter(Context context, ArrayList<TripModel> tripModels) {
        this.context=context;
        this.tripModels=tripModels;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.itemdoctrip, parent, false);
        return new RecViewHolder(view);
    }

    //@SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, final int position) {

        Glide.with(holder.m_img.getContext()).load(tripModels.get(position).getEntranceImage()).into(holder.m_img);
        holder.m_quary.setText(tripModels.get(position).getQueryId());
        holder.m_tripname.setText(tripModels.get(position).getTripName());
        holder.m_duration.setText(tripModels.get(position).getTripDuration());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(context, VouchersAct.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return tripModels.size();
    }

    class RecViewHolder extends RecyclerView.ViewHolder {

        TextView m_quary,m_tripname,m_duration;
        ImageView m_img;


        public RecViewHolder(@NonNull final View itemView) {

            super(itemView);
            m_tripname = itemView.findViewById(R.id.tripname_DOCTRIP);
            m_quary = itemView.findViewById(R.id.queryid_DOCTRIP);
            m_duration = itemView.findViewById(R.id.tripduration_DOCTRIP);
            m_img = itemView.findViewById(R.id.img_DOCTRIP);

        }
    }

}