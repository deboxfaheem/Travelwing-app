package com.travelwings.trav_client;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdpater extends RecyclerView.Adapter<ImageAdpater.ImageHolder> {

    ArrayList<String> results;
    Context context;

    public ImageAdpater(Context applicationContext, ArrayList<String> mResults) {
        this.results=mResults;
        this.context=applicationContext;

    }

    @NonNull
    @Override
    public ImageAdpater.ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view,parent,false);
        ImageHolder documentHolder=new ImageHolder(view);
        return documentHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdpater.ImageHolder holder, int position) {

        //Bitmap bitmap= BitmapFactory.decodeFile(results.get(position));
     //  bitmap = Bitmap.createScaledBitmap(bitmap,350, 300, true);
      //  holder.imageView.setImageBitmap(bitmap);

        GlideApp.with(context).load(results.get(position)).into(holder.imageView);


      // Picasso.with(context).load(results.get(position)).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ImageHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imagevi);
        }
    }
}
