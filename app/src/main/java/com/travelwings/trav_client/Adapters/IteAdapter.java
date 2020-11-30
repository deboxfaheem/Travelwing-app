package com.travelwings.trav_client.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.R;
import com.travelwings.trav_client.rest.MyClickActivity;
import com.travelwings.trav_client.rest.MyClickEntrance;
import com.travelwings.trav_client.rest.MyClickEvents;
import com.travelwings.trav_client.rest.MyClickFeed;
import com.travelwings.trav_client.rest.MyClickTransfer;
import com.travelwings.trav_client.rest.MyClickTransport;
import com.travelwings.trav_client.rest.MyClickTrip;

import java.util.ArrayList;

public class IteAdapter extends RecyclerView.Adapter<IteAdapter.RecViewHolder> {

    Context context;
    private static final String TAG = IteAdapter.class.getSimpleName();
  //  ArrayList<Result> result;
    ArrayList<DayModel> days;
    String feedback;
    MyClickEvents myClickEvents;
    MyClickTransfer myClickTransfer;
    MyClickActivity myClickActivity;
    MyClickEntrance myClickEntrance;
    MyClickTransport myClickTransport;
    MyClickFeed myClickFeed;
    MyClickTrip myClickTrip;
  // CurrentItineraryFragment currentItineraryFragment;

    public IteAdapter(Context context, Fragment fragment, ArrayList<DayModel> days, String feedback) {

     //   this.currentItineraryFragment=currentItineraryFragment;
        this.context=context;
        this.days = days;
        this.feedback=feedback;
        myClickEvents=(MyClickEvents) context;
        myClickTransfer=(MyClickTransfer) context;
        myClickActivity=(MyClickActivity) context;
        myClickEntrance=(MyClickEntrance) context;
        myClickTransport=(MyClickTransport) context;
        myClickFeed=(MyClickFeed) fragment;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.itemlatestiternity, parent, false);
    //         View view = layoutInflater.inflate(R.layout.item_trend_music, parent, false);
        return new RecViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull final RecViewHolder holder, final int position) {

        /*User users=user[position];
        holder.m_text.setText(users.getLogin());
        Glide.with(holder.m_img.getContext()).load(users.getAvatarUrl()).into(holder.m_img);*/
      //  holder.m_tripname.setText(result.get(position).getTripName());

        holder.setIsRecyclable(false);
                final DayModel day = days.get(position);
                if (day != null) {
                    holder.m_time.setText(day.getDay());
                    Log.e("Mylog","My DATE IS "+ day.getDay());
                    holder.m_date.setText(day.getDate());
                    holder.m_destination.setText(day.getCityId());

                    if (day.getHotel() != null) {

                        for (int i1 = 0; i1 < day.getHotel().size(); i1++) {
                            Log.e(TAG, "onBindViewHolder: Hotel: " + day.getHotel().get(i1).getHotelName() + ", Day: " + day.getDay());

                            if(day.getHotel().get(i1)!=null) {

                                holder.m_hotelname.setText(day.getHotel().get(i1).getHotelName());
                                holder.m_roomtype.setText(day.getHotel().get(i1).getRoomType());
                                holder.m_meal.setText(day.getHotel().get(i1).getMealPlan());


                                String star = day.getHotel().get(i1).getHotelcategory();

                                switch (star) {
                                    case "5 Star":
                                        holder.m_hotelcate.setImageResource(R.mipmap.fivestarrrl);
                                        break;
                                    case "4 Star":
                                        holder.m_hotelcate.setImageResource(R.mipmap.fourstarrr1);
                                        break;
                                    case "3 Star":
                                        holder.m_hotelcate.setImageResource(R.mipmap.threestarrr1);
                                        break;
                                    case "2 Star":
                                        holder.m_hotelcate.setImageResource(R.mipmap.twostarrr1);
                                        break;
                                    default:
                                        holder.m_hotelcate.setImageResource(R.mipmap.onestarrr1);
                                        break;
                                }
                            }

                        }
                    }
                    //  holder.m_vetransfer.setText(result.get(position).getVetransferName());
                    //    holder.m_vetype.setText(result.get(position).getVetype());
                    //   holder.m_vename.setText(result.get(position).getVename());
                    //   holder.m_entrance.setText(result.get(position).getEntranceName());

                    if (day.getActivity() != null) {

                        for (int i2 = 0; i2 < day.getActivity().size(); i2++) {

                            if (day.getActivity().get(i2) != null) {
                                holder.m_otherActivityname.setText(day.getActivity().get(i2).getActivityName());
                                holder.m_astart.setText(day.getActivity().get(i2).getStartTime());
                                holder.m_aend.setText(day.getActivity().get(i2).getEndTime());
                            }
                        }

                        if (day.getFlight() != null) {

                            for (int i3 = 0; i3 < day.getFlight().size(); i3++) {

                                if (day.getFlight().get(i3) != null) {
                                    holder.m_fname.setText(day.getFlight().get(i3).getFlightName());
                                    holder.m_ftype.setText(day.getFlight().get(i3).getServiceType());
                                    holder.m_fnumber.setText(day.getFlight().get(i3).getFlightNumber());
                                    holder.m_fclas.setText(day.getFlight().get(i3).getFlightClass());
                                    holder.m_ffromdest.setText(day.getFlight().get(i3).getFromDest());
                                    holder.m_ftodest.setText(day.getFlight().get(i3).getToDest());
                                    holder.m_farrivaldate.setText(day.getFlight().get(i3).getArrivalDate());
                                    holder.m_farrivaltime.setText(day.getFlight().get(i3).getArrivalTime());
                                    holder.m_fdeparturedate.setText(day.getFlight().get(i3).getDepartureDate());
                                    holder.m_fdeparturetime.setText(day.getFlight().get(i3).getDepartureTime());
                                }
                            }
                        }
                    }
        }

       /* holder.m_noofroom.setText(result.get(position).getNoofrooms());

        holder.m_estart.setText(result.get(position).getEstartTime());
        holder.m_eend.setText(result.get(position).getEendTime());
        holder.m_tpickup.setText(result.get(position).getTpickupTime());
        holder.m_tdrop.setText(result.get(position).getTdropTime());
*/




     //   Glide.with(holder.m_activityIMG.getContext()).load(result.get(position).getActivityImage()).into(holder.m_activityIMG);
      //  Glide.with(holder.m_entranceIMG.getContext()).load(result.get(position).getEntranceImage()).into(holder.m_entranceIMG);
      /*  Glide.with(holder.m_activityIMG.getContext()).load(result.get(position).getActivityImage()).into(holder.m_activityIMG);
        Glide.with(holder.m_entranceIMG.getContext()).load(result.get(position).getEntranceImage()).into(holder.m_entranceIMG);
        Glide.with(holder.m_transferIMG.getContext()).load(result.get(position).getImage1()).into(holder.m_transferIMG);*/
    //    holder.m_hotelvoucher.setText(voucherData.get(position).getId());

       holder.m_hotelvoucher.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               myClickTransfer.onTransferClick(days.get(position).getFlight(),position);
           }
       });

        holder.m_hotelvoucher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickEvents.onListClick(days.get(position).getHotel(),position);
            }
        });

        holder.m_hotelvoucher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickActivity.onActivtiyClick(days.get(position).getFlight(),position);
            }
        });

        holder.m_hotelvoucher3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickEntrance.onEntranceClick(days.get(position).getFlight(),position);
            }
        });

        holder.m_hotelvoucher4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myClickTransport.onTransportClick(days.get(position).getFlight(),position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return days.size();
    }



    class RecViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView  m_time, m_date, m_meal, m_roomtype, m_hotelname, m_vetransfer, m_vetype, m_destination, m_vename,
                m_entrance, m_otherActivityname, m_noofroom, m_tpickup, m_tdrop, m_estart, m_eend, m_astart, m_aend,
                m_fname,m_ftype,m_fnumber,m_fclas,m_ffromdest,m_ftodest,m_farrivaldate,m_farrivaltime,m_fdeparturedate,m_fdeparturetime;

        TextView m_hotelvoucher, m_hotelvoucher1, m_hotelvoucher2, m_hotelvoucher3, m_hotelvoucher4;
        ImageView m_smilysad, m_smilyhappy, m_smilynutral, m_smilysadgray, m_smilyhappygray, m_smilynutralgray,
                m_smilysad1, m_smilyhappy1, m_smilynutral1, m_smilysadgray1, m_smilyhappygray1, m_smilynutralgray1,
                m_smilysad2, m_smilyhappy2, m_smilynutral2, m_smilysadgray2, m_smilyhappygray2, m_smilynutralgray2,
                m_smilysad3, m_smilyhappy3, m_smilynutral3, m_smilysadgray3, m_smilyhappygray3, m_smilynutralgray3,
                m_smilysad4, m_smilyhappy4, m_smilynutral4, m_smilysadgray4, m_smilyhappygray4, m_smilynutralgray4,
                m_activityIMG, m_entranceIMG, m_transferIMG, m_hotelcate;

        LinearLayout m_llemoji;

        public RecViewHolder(@NonNull final View itemView) {

            super(itemView);
            //    m_tripname= itemView.findViewById(R.id.tripname_ITE);

            m_fname=itemView.findViewById(R.id.flightname_ITE);
            m_ftype=itemView.findViewById(R.id.flighttype_ITE);
            m_fnumber=itemView.findViewById(R.id.flightno_ITE);
            m_fclas=itemView.findViewById(R.id.flightclass_ITE);
            m_ffromdest=itemView.findViewById(R.id.ffromdest_ITE);
            m_ftodest=itemView.findViewById(R.id.ftodest_ITE);
            m_farrivaldate=itemView.findViewById(R.id.farrivaldate_ITE);
            m_farrivaltime=itemView.findViewById(R.id.farrivaltime_ITE);
            m_fdeparturedate=itemView.findViewById(R.id.fdeparturedate_ITE);
            m_fdeparturetime=itemView.findViewById(R.id.departuretime_ITE);



            m_time = itemView.findViewById(R.id.time_ITE);
            m_date = itemView.findViewById(R.id.date_ITE);
            m_hotelname = itemView.findViewById(R.id.hotelname_ITE);
            m_hotelcate = itemView.findViewById(R.id.hotelcate_ITE);
            m_roomtype = itemView.findViewById(R.id.roomtype_ITE);
            m_meal = itemView.findViewById(R.id.mealplan_ITE);
            m_vetransfer = itemView.findViewById(R.id.vetransferName_ITE);
            m_vetype = itemView.findViewById(R.id.vetype_ITE);
            m_destination = itemView.findViewById(R.id.destination_ITE);
            m_vename = itemView.findViewById(R.id.vename_ITTE);
            m_entrance = itemView.findViewById(R.id.entranceName_ITE);
            m_otherActivityname = itemView.findViewById(R.id.otherActivityName);
            m_noofroom = itemView.findViewById(R.id.noroom_ITE);
            m_activityIMG = itemView.findViewById(R.id.activityImg_ITE);
            m_entranceIMG = itemView.findViewById(R.id.entanceImg_ITE);
            m_transferIMG = itemView.findViewById(R.id.transferImg_ITE);
            m_estart = itemView.findViewById(R.id.estarttime_ITE);
            m_eend = itemView.findViewById(R.id.eendtime_ITE);
            m_tpickup = itemView.findViewById(R.id.tpickuptime_ITE);
            m_tdrop = itemView.findViewById(R.id.tdroptime_ITE);
            m_astart = itemView.findViewById(R.id.astarttime_ITE);
            m_aend = itemView.findViewById(R.id.aendtime_ITE);

            m_llemoji= itemView.findViewById(R.id.llemoji_ITE);

            m_hotelvoucher = itemView.findViewById(R.id.hotelvoucher_ITE);
            m_hotelvoucher1 = itemView.findViewById(R.id.hotelvoucher1_ITE);
            m_hotelvoucher2 = itemView.findViewById(R.id.hotelvoucher2_ITE);
            m_hotelvoucher3 = itemView.findViewById(R.id.hotelvoucher3_ITE);
            m_hotelvoucher4 = itemView.findViewById(R.id.hotelvoucher4_ITE);

            m_smilyhappy = itemView.findViewById(R.id.smileyhappy_ITE);
            m_smilysad = itemView.findViewById(R.id.smileysad_ITE);
            m_smilynutral = itemView.findViewById(R.id.smileynutral_ITE);

            m_smilyhappygray = itemView.findViewById(R.id.smileyhappygray_ITE);
            m_smilysadgray = itemView.findViewById(R.id.smileysadgray_ITE);
            m_smilynutralgray = itemView.findViewById(R.id.smileynutralgray_ITE);

            m_smilyhappy1 = itemView.findViewById(R.id.smileyhappy1_ITE);
            m_smilysad1 = itemView.findViewById(R.id.smileysad1_ITE);
            m_smilynutral1 = itemView.findViewById(R.id.smileynutral1_ITE);

            m_smilyhappygray1 = itemView.findViewById(R.id.smileyhappygray1_ITE);
            m_smilysadgray1 = itemView.findViewById(R.id.smileysadgray1_ITE);
            m_smilynutralgray1 = itemView.findViewById(R.id.smileynutralgray1_ITE);

            m_smilyhappy2 = itemView.findViewById(R.id.smileyhappy2_ITE);
            m_smilysad2 = itemView.findViewById(R.id.smileysad2_ITE);
            m_smilynutral2 = itemView.findViewById(R.id.smileynutral2_ITE);

            m_smilyhappygray2 = itemView.findViewById(R.id.smileyhappygray2_ITE);
            m_smilysadgray2 = itemView.findViewById(R.id.smileysadgray2_ITE);
            m_smilynutralgray2 = itemView.findViewById(R.id.smileynutralgray2_ITE);

            m_smilyhappy3 = itemView.findViewById(R.id.smileyhappy3_ITE);
            m_smilysad3 = itemView.findViewById(R.id.smileysad3_ITE);
            m_smilynutral3 = itemView.findViewById(R.id.smileynutral3_ITE);

            m_smilyhappygray3 = itemView.findViewById(R.id.smileyhappygray3_ITE);
            m_smilysadgray3 = itemView.findViewById(R.id.smileysadgray3_ITE);
            m_smilynutralgray3 = itemView.findViewById(R.id.smileynutralgray3_ITE);

            m_smilyhappy4 = itemView.findViewById(R.id.smileyhappy4_ITE);
            m_smilysad4 = itemView.findViewById(R.id.smileysad4_ITE);
            m_smilynutral4 = itemView.findViewById(R.id.smileynutral4_ITE);

            m_smilyhappygray4 = itemView.findViewById(R.id.smileyhappygray4_ITE);
            m_smilysadgray4 = itemView.findViewById(R.id.smileysadgray4_ITE);
            m_smilynutralgray4 = itemView.findViewById(R.id.smileynutralgray4_ITE);


            m_smilyhappygray.setOnClickListener(this);
            m_smilysadgray.setOnClickListener(this);
            m_smilynutralgray.setOnClickListener(this);
            m_smilyhappy.setOnClickListener(this);
            m_smilysad.setOnClickListener(this);
            m_smilynutral.setOnClickListener(this);

            m_smilyhappygray1.setOnClickListener(this);
            m_smilysadgray1.setOnClickListener(this);
            m_smilynutralgray1.setOnClickListener(this);
            m_smilyhappy1.setOnClickListener(this);
            m_smilysad1.setOnClickListener(this);
            m_smilynutral1.setOnClickListener(this);

            m_smilyhappygray2.setOnClickListener(this);
            m_smilysadgray2.setOnClickListener(this);
            m_smilynutralgray2.setOnClickListener(this);
            m_smilyhappy2.setOnClickListener(this);
            m_smilysad2.setOnClickListener(this);
            m_smilynutral2.setOnClickListener(this);

            m_smilyhappygray3.setOnClickListener(this);
            m_smilysadgray3.setOnClickListener(this);
            m_smilynutralgray3.setOnClickListener(this);
            m_smilyhappy3.setOnClickListener(this);
            m_smilysad3.setOnClickListener(this);
            m_smilynutral3.setOnClickListener(this);

            m_smilyhappygray4.setOnClickListener(this);
            m_smilysadgray4.setOnClickListener(this);
            m_smilynutralgray4.setOnClickListener(this);
            m_smilyhappy4.setOnClickListener(this);
            m_smilysad4.setOnClickListener(this);
            m_smilynutral4.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.smileysad_ITE:
                    m_smilysadgray.setVisibility(View.VISIBLE);
                    m_smilynutral.setVisibility(View.VISIBLE);
                    m_smilyhappy.setVisibility(View.VISIBLE);
                    m_smilynutralgray.setVisibility(View.GONE);
                    m_smilyhappygray.setVisibility(View.GONE);
                    m_smilysad.setVisibility(View.GONE);
                    //      myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray.setEnabled(false);
                    m_smilynutral.setEnabled(false);
                    m_smilyhappy.setEnabled(false);
                    m_smilynutralgray.setEnabled(false);
                    m_smilyhappygray.setEnabled(false);
                    m_smilysad.setEnabled(false);

                    //     Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileyhappy_ITE:
                    m_smilyhappygray.setVisibility(View.VISIBLE);
                    m_smilynutral.setVisibility(View.VISIBLE);
                    m_smilysad.setVisibility(View.VISIBLE);
                    m_smilynutralgray.setVisibility(View.GONE);
                    m_smilysadgray.setVisibility(View.GONE);
                    m_smilyhappy.setVisibility(View.GONE);
                    //     myDialogHappy();
                    myClickFeed.onFeedClick(feedback);
                    m_smilysadgray.setEnabled(false);
                    m_smilynutral.setEnabled(false);
                    m_smilyhappy.setEnabled(false);
                    m_smilynutralgray.setEnabled(false);
                    m_smilyhappygray.setEnabled(false);
                    m_smilysad.setEnabled(false);
                    break;

                case R.id.smileynutral_ITE:
                    m_smilynutralgray.setVisibility(View.VISIBLE);
                    m_smilyhappy.setVisibility(View.VISIBLE);
                    m_smilysad.setVisibility(View.VISIBLE);
                    m_smilysadgray.setVisibility(View.GONE);
                    m_smilyhappygray.setVisibility(View.GONE);
                    m_smilynutral.setVisibility(View.GONE);
                    //    myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray.setEnabled(false);
                    m_smilynutral.setEnabled(false);
                    m_smilyhappy.setEnabled(false);
                    m_smilynutralgray.setEnabled(false);
                    m_smilyhappygray.setEnabled(false);
                    m_smilysad.setEnabled(false);
                    //    Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.smileysad1_ITE:
                    m_smilysadgray1.setVisibility(View.VISIBLE);
                    m_smilynutral1.setVisibility(View.VISIBLE);
                    m_smilyhappy1.setVisibility(View.VISIBLE);
                    m_smilynutralgray1.setVisibility(View.GONE);
                    m_smilyhappygray1.setVisibility(View.GONE);
                    m_smilysad1.setVisibility(View.GONE);
                    //  myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray1.setEnabled(false);
                    m_smilynutral1.setEnabled(false);
                    m_smilyhappy1.setEnabled(false);
                    m_smilynutralgray1.setEnabled(false);
                    m_smilyhappygray1.setEnabled(false);
                    m_smilysad1.setEnabled(false);
                    //   Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileyhappy1_ITE:
                    m_smilyhappygray1.setVisibility(View.VISIBLE);
                    m_smilynutral1.setVisibility(View.VISIBLE);
                    m_smilysad1.setVisibility(View.VISIBLE);
                    m_smilynutralgray1.setVisibility(View.GONE);
                    m_smilysadgray1.setVisibility(View.GONE);
                    m_smilyhappy1.setVisibility(View.GONE);
                    //    myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray1.setEnabled(false);
                    m_smilynutral1.setEnabled(false);
                    m_smilyhappy1.setEnabled(false);
                    m_smilynutralgray1.setEnabled(false);
                    m_smilyhappygray1.setEnabled(false);
                    m_smilysad1.setEnabled(false);
                    //   Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileynutral1_ITE:
                    m_smilynutralgray1.setVisibility(View.VISIBLE);
                    m_smilyhappy1.setVisibility(View.VISIBLE);
                    m_smilysad1.setVisibility(View.VISIBLE);
                    m_smilysadgray1.setVisibility(View.GONE);
                    m_smilyhappygray1.setVisibility(View.GONE);
                    m_smilynutral1.setVisibility(View.GONE);
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray1.setEnabled(false);
                    m_smilynutral1.setEnabled(false);
                    m_smilyhappy1.setEnabled(false);
                    m_smilynutralgray1.setEnabled(false);
                    m_smilyhappygray1.setEnabled(false);
                    m_smilysad1.setEnabled(false);
                    //    myDialogHappy();
                    //  Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.smileysad2_ITE:
                    m_smilysadgray2.setVisibility(View.VISIBLE);
                    m_smilynutral2.setVisibility(View.VISIBLE);
                    m_smilyhappy2.setVisibility(View.VISIBLE);
                    m_smilynutralgray2.setVisibility(View.GONE);
                    m_smilyhappygray2.setVisibility(View.GONE);
                    m_smilysad2.setVisibility(View.GONE);
                    //    myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray2.setEnabled(false);
                    m_smilynutral2.setEnabled(false);
                    m_smilyhappy2.setEnabled(false);
                    m_smilynutralgray2.setEnabled(false);
                    m_smilyhappygray2.setEnabled(false);
                    m_smilysad2.setEnabled(false);
                    //    Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileyhappy2_ITE:
                    m_smilyhappygray2.setVisibility(View.VISIBLE);
                    m_smilynutral2.setVisibility(View.VISIBLE);
                    m_smilysad2.setVisibility(View.VISIBLE);
                    m_smilynutralgray2.setVisibility(View.GONE);
                    m_smilysadgray2.setVisibility(View.GONE);
                    m_smilyhappy2.setVisibility(View.GONE);
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray2.setEnabled(false);
                    m_smilynutral2.setEnabled(false);
                    m_smilyhappy2.setEnabled(false);
                    m_smilynutralgray2.setEnabled(false);
                    m_smilyhappygray2.setEnabled(false);
                    m_smilysad2.setEnabled(false);
                    //    myDialogHappy();
                    //   Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();

                    break;

                case R.id.smileynutral2_ITE:
                    m_smilynutralgray2.setVisibility(View.VISIBLE);
                    m_smilyhappy2.setVisibility(View.VISIBLE);
                    m_smilysad2.setVisibility(View.VISIBLE);
                    m_smilysadgray2.setVisibility(View.GONE);
                    m_smilyhappygray2.setVisibility(View.GONE);
                    m_smilynutral2.setVisibility(View.GONE);
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray2.setEnabled(false);
                    m_smilynutral2.setEnabled(false);
                    m_smilyhappy2.setEnabled(false);
                    m_smilynutralgray2.setEnabled(false);
                    m_smilyhappygray2.setEnabled(false);
                    m_smilysad2.setEnabled(false);
                    //     myDialogHappy();
                    //    Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.smileysad3_ITE:
                    m_smilysadgray3.setVisibility(View.VISIBLE);
                    m_smilynutral3.setVisibility(View.VISIBLE);
                    m_smilyhappy3.setVisibility(View.VISIBLE);
                    m_smilynutralgray3.setVisibility(View.GONE);
                    m_smilyhappygray3.setVisibility(View.GONE);
                    m_smilysad3.setVisibility(View.GONE);
                    //    myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray3.setEnabled(false);
                    m_smilynutral3.setEnabled(false);
                    m_smilyhappy3.setEnabled(false);
                    m_smilynutralgray3.setEnabled(false);
                    m_smilyhappygray3.setEnabled(false);
                    m_smilysad3.setEnabled(false);
                    //  Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileyhappy3_ITE:
                    m_smilyhappygray3.setVisibility(View.VISIBLE);
                    m_smilynutral3.setVisibility(View.VISIBLE);
                    m_smilysad3.setVisibility(View.VISIBLE);
                    m_smilynutralgray3.setVisibility(View.GONE);
                    m_smilysadgray3.setVisibility(View.GONE);
                    m_smilyhappy3.setVisibility(View.GONE);
                    //     myDialogHappy();
                    myClickFeed.onFeedClick(feedback);
                    m_smilysadgray3.setEnabled(false);
                    m_smilynutral3.setEnabled(false);
                    m_smilyhappy3.setEnabled(false);
                    m_smilynutralgray3.setEnabled(false);
                    m_smilyhappygray3.setEnabled(false);
                    m_smilysad3.setEnabled(false);
                    //   Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileynutral3_ITE:
                    m_smilynutralgray3.setVisibility(View.VISIBLE);
                    m_smilyhappy3.setVisibility(View.VISIBLE);
                    m_smilysad3.setVisibility(View.VISIBLE);
                    m_smilysadgray3.setVisibility(View.GONE);
                    m_smilyhappygray3.setVisibility(View.GONE);
                    m_smilynutral3.setVisibility(View.GONE);
                    //   myDialogHappy();
                    myClickFeed.onFeedClick(feedback);
                    //    Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.smileysad4_ITE:
                    m_smilysadgray4.setVisibility(View.VISIBLE);
                    m_smilynutral4.setVisibility(View.VISIBLE);
                    m_smilyhappy4.setVisibility(View.VISIBLE);
                    m_smilynutralgray4.setVisibility(View.GONE);
                    m_smilyhappygray4.setVisibility(View.GONE);
                    m_smilysad4.setVisibility(View.GONE);
                    //   myDialogHappy();
                    myClickFeed.onFeedClick(feedback);
                    m_smilysadgray4.setEnabled(false);
                    m_smilynutral4.setEnabled(false);
                    m_smilyhappy4.setEnabled(false);
                    m_smilynutralgray4.setEnabled(false);
                    m_smilyhappygray4.setEnabled(false);
                    m_smilysad4.setEnabled(false);
                    //   Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileyhappy4_ITE:
                    m_smilyhappygray4.setVisibility(View.VISIBLE);
                    m_smilynutral4.setVisibility(View.VISIBLE);
                    m_smilysad4.setVisibility(View.VISIBLE);
                    m_smilynutralgray4.setVisibility(View.GONE);
                    m_smilysadgray4.setVisibility(View.GONE);
                    m_smilyhappy4.setVisibility(View.GONE);
                    //  myDialogHappy();
                    myClickFeed.onFeedClick(feedback);

                    m_smilysadgray4.setEnabled(false);
                    m_smilynutral4.setEnabled(false);
                    m_smilyhappy4.setEnabled(false);
                    m_smilynutralgray4.setEnabled(false);
                    m_smilyhappygray4.setEnabled(false);
                    m_smilysad4.setEnabled(false);
                    //    Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.smileynutral4_ITE:
                    m_smilynutralgray4.setVisibility(View.VISIBLE);
                    m_smilyhappy4.setVisibility(View.VISIBLE);
                    m_smilysad4.setVisibility(View.VISIBLE);
                    m_smilysadgray4.setVisibility(View.GONE);
                    m_smilyhappygray4.setVisibility(View.GONE);
                    m_smilynutral4.setVisibility(View.GONE);
                    //    myDialogHappy();
                    myClickFeed.onFeedClick(feedback);
                    m_smilysadgray4.setEnabled(false);
                    m_smilynutral4.setEnabled(false);
                    m_smilyhappy4.setEnabled(false);
                    m_smilynutralgray4.setEnabled(false);
                    m_smilyhappygray4.setEnabled(false);
                    m_smilysad4.setEnabled(false);
                    //    Toast.makeText(itemView.getContext(),"Thankyou your FeedBack",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }


}