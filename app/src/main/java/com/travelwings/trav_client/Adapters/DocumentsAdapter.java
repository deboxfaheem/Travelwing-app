package com.travelwings.trav_client.Adapters;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.travelwings.trav_client.Fragments.ViewDocumentFragment;
import com.travelwings.trav_client.Models.Resultpas;
import com.travelwings.trav_client.R;

import java.io.Serializable;
import java.util.ArrayList;


public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.DocumentHolder> {


    Context context;
  // List<DocumentModel> documentModelArrayList;
    ArrayList<Resultpas> resultpas;
    FragmentManager fragmentManager;

    public DocumentsAdapter(Context context,ArrayList<Resultpas> resultpas,FragmentManager fragmentManager) {
        this.context=context;
        this.resultpas=resultpas;
        this.fragmentManager=fragmentManager;

    }



    @NonNull
    @Override
    public DocumentsAdapter.DocumentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.document_items,viewGroup,false);
        DocumentHolder documentHolder=new DocumentHolder(view);
        return documentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentsAdapter.DocumentHolder documentHolder, final int position) {


       // final DocumentModel documentModel=documentModelArrayList.get(i);
   //     documentHolder.name.setText(documentModel.getDocumentType());

      //  resultpas1.setIndex(i);

        if(resultpas.get(position).getDocumentType().equals("PASSPORT")){

            documentHolder.img_doc.setImageResource(R.drawable.passport);


        }
        else if(resultpas.get(position).getDocumentType().equals("VOTER ID")){

            documentHolder.img_doc.setImageResource(R.drawable.voterid);


        } else if(resultpas.get(position).getDocumentType().equals("AADHAAR")){

            documentHolder.img_doc.setImageResource(R.drawable.aadhar);

        } else if(resultpas.get(position).getDocumentType().equals("VISA")){
            documentHolder.img_doc.setImageResource(R.drawable.visa);


        } else if(resultpas.get(position).getDocumentType().equals("PAN")){

            documentHolder.img_doc.setImageResource(R.drawable.pancard);

        }
        else {

            documentHolder.img_doc.setImageResource(R.drawable.frequent);

        }
        documentHolder.img_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                opendetailsdialog();


            }

            private void opendetailsdialog() {

                {

                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dlg_dismiss);
                    dialog.setCanceledOnTouchOutside(true);

                    TextView number = (TextView) dialog.findViewById(R.id.document_number);
                    TextView issuedate = (TextView) dialog.findViewById(R.id.issue_date);
                    TextView expirydate = (TextView) dialog.findViewById(R.id.expiry_date);
                    TextView country = (TextView) dialog.findViewById(R.id.country_);
                    TextView viewdoc = (TextView) dialog.findViewById(R.id.view_document);
                     TextView uploaddoc = (TextView) dialog.findViewById(R.id.upload_document2);

                    issuedate.setText(resultpas.get(position).getIssueDate());
                    expirydate.setText(resultpas.get(position).getExpiryDate());
                    country.setText(" "+ resultpas.get(position).getCountry());
                    number.setText(resultpas.get(position).getDocumentNo());

                    SharedPreferences prefs = context.getSharedPreferences("docs"+position, Context.MODE_PRIVATE);
                    Boolean aBoolean = prefs.getBoolean("docu", false);
                   if(aBoolean!=null){

                       Boolean finalb=prefs.getBoolean("docu",false);
                       if(aBoolean==true){

                           viewdoc.setVisibility(View.VISIBLE);
                           uploaddoc.setVisibility(View.GONE);

                       }
                       else{
                           uploaddoc.setVisibility(View.VISIBLE);
                           viewdoc.setVisibility(View.GONE);



                       }
                   }
                  //  PreferenceManager preferenceManager = new PreferenceManager(context);



                    uploaddoc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            ViewDocumentFragment ldf = new ViewDocumentFragment ();
                            Bundle args = new Bundle();
                            args.putString("title", resultpas.get(position).getDocumentType());
                        //    args.putInt("index", documentModel.getIndex());
                            args.putSerializable("key", (Serializable) resultpas);
                          //  args.putStringArrayList("key",  resultpas.get(position));
                            ldf.setArguments(args);
                            fragmentManager.beginTransaction().replace(R.id.frag_pesonal_DOC, ldf).addToBackStack("hdgh").commit();
                            dialog.dismiss();

                        }
                    });

                    viewdoc.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            ViewDocumentFragment ldf = new ViewDocumentFragment ();
                            Bundle args = new Bundle();
                            args.putString("title", resultpas.get(position).getDocumentType());
                         //   args.putInt("index", documentModel.getIndex());
                            args.putSerializable("key", (Serializable) resultpas.get(position));
                            ldf.setArguments(args);
                            fragmentManager.beginTransaction().replace(R.id.frag_pesonal_DOC, ldf).addToBackStack("hdgh").commit();
                            dialog.dismiss();
                        }
                    });

                    dialog.setCanceledOnTouchOutside(true);
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.document_details_background);
                  //  dialog.getWindow().setBackgroundDrawableResource(R.drawable.document_details_background);

                    dialog.show();



                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return resultpas.size();
    }

    public class DocumentHolder extends RecyclerView.ViewHolder {


        TextView name,btn;
        ImageView image,img_doc;
        public DocumentHolder(@NonNull View itemView) {
            super(itemView);

     //     name=itemView.findViewById(R.id.name_doc);
       //   image=itemView.findViewById(R.id.img_doc);
          img_doc=itemView.findViewById(R.id.image_doc);
         // btn=itemView.findViewById(R.id.btn_view_doc);

        }
    }
}
