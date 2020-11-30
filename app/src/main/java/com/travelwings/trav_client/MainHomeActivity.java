package com.travelwings.trav_client;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

//import com.example.client_trav.Fragments.AccountFragment;
import com.travelwings.trav_client.Fragments.CurrentItineraryFragment;
import com.travelwings.trav_client.Fragments.DocumentFrag;
import com.travelwings.trav_client.Fragments.FeedbackFrag;

//import com.example.client_trav.Fragments.ItineraryFragment;

import com.travelwings.trav_client.Fragments.WeatherFragment;
import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.FlightModel;
import com.travelwings.trav_client.Models.HotelModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.Result;
import com.travelwings.trav_client.rest.Data;
import com.travelwings.trav_client.rest.MyClickActivity;
import com.travelwings.trav_client.rest.MyClickEntrance;
import com.travelwings.trav_client.rest.MyClickEvents;
import com.travelwings.trav_client.rest.MyClickTransfer;
import com.travelwings.trav_client.rest.MyClickTransport;
import com.travelwings.trav_client.rest.MyClickTrip;


import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener,MyClickEvents,
        MyClickTrip, MyClickTransfer, MyClickActivity, MyClickEntrance, MyClickTransport {

    WebServices webServices;
    BottomNavigationView bottomNavigationView;
    FrameLayout m_frame3;

    ImageView ly_itinerary, ly_documents, ly_feedback, ly_utilities, ly_referearn, ly_covid;

    ImageView imageView_header;
    ImageView dashboard_menu;
    RecyclerView recyclerView;
    WebServices webServices2;
    TextView name2, number, email, clientname;

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

       // checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);

        dashboard_menu = findViewById(R.id.navigation_icon);
        clientname = findViewById(R.id.text_client);

        ly_itinerary = findViewById(R.id.lay_one);
        ly_documents = findViewById(R.id.lay_two);
        ly_feedback = findViewById(R.id.lay_three);
        ly_utilities = findViewById(R.id.lay_four);
        ly_referearn = findViewById(R.id.lay_six);
        ly_covid = findViewById(R.id.lay_five);

        m_frame3=findViewById(R.id.main_container3);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        webServices2 = (WebServices) getApplicationContext().getApplicationContext();


        dashboard_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawer.openDrawer(GravityCompat.START);
            }
        });

        SharedPreferences sharedPreferences = MainHomeActivity.this.getSharedPreferences("updateclient", Context.MODE_PRIVATE);
         String fname = sharedPreferences.getString("firstName1", "");
        String lname = sharedPreferences.getString("lastName1", "");
         String emailid = sharedPreferences.getString("email1", "");
        String phonenumber = sharedPreferences.getString("mobile1", "");

        Log.e("mylog","Shared name is " +fname);
       Log.e("mylog","Shared Email ID is " +emailid);

       /* String name= getIntent().getStringExtra("firstName1");
        String emailid= getIntent().getStringExtra("email1");
        String phonenumber= getIntent().getStringExtra("mobile1");*/

        clientname.setText("Welcome " + fname +" "+ lname);

        bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigationView.setItemIconTintList(null);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItemf = menu.getItem(0);
        menuItemf.setIcon(R.drawable.homegray);

        this.setTitle("HOME");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        webServices = (WebServices) getBaseContext().getApplicationContext();

        ly_itinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new CurrentItineraryFragment()).addToBackStack("hdgh").commit();

            }
        });

        ly_covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainHomeActivity.this, Pertrav.class);
                startActivity(i);
            }
        });


        ly_documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainHomeActivity.this, DocumentsActivity.class);
                startActivity(i);
            }
        });

        ly_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.main_container, new FeedbackFrag()).addToBackStack("hdgh").commit();

            }
        });
        ly_utilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainHomeActivity.this, UtilityAcitivity.class);
                startActivity(i);
            }
        });
        ly_referearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainHomeActivity.this, ReferalActivity.class);
                startActivity(i);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        name2 = header.findViewById(R.id.fullname_header);
        imageView_header = header.findViewById(R.id.imageView_header);
        final TextView edit = header.findViewById(R.id.edit_profile_header);
        email = header.findViewById(R.id.email_header);
        number = header.findViewById(R.id.mobile_number_header);
        name2.setText(fname +" "+ lname);
        email.setText(emailid);
        number.setText(phonenumber);

        loadprofileimage();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainHomeActivity.this, MainActivityProfile.class);
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemIconTintList(null);


    }

    private void loadprofileimage() {


        SharedPreferences sharedPreferences = getSharedPreferences("saveprofile", Context.MODE_PRIVATE);

        String imagedata = sharedPreferences.getString("image_data", "");
        //        Toast.makeText(this, imagedata, Toast.LENGTH_SHORT).show();
        if (imagedata.isEmpty()) {

            // Toast.makeText(DemoActivity.this, "No pictures to show...", Toast.LENGTH_LONG).show();

            loaddefault();
        } else {
            //   imgProfile.setImageBitmap(decodeBase64(image_data));

            loadProfile(imagedata);
            //  Log.d("mylog",image_data);
            //    Toast.makeText(this, image_data.toString()+"no data", Toast.LENGTH_LONG).show();
            //   imgProfile.setImageDrawable(getResources().getDrawable(R.drawable.logo_debox));

        }

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loaddefault() {

        GlideApp.with(this).load(R.drawable.baseline_account_circle_black_48).into(imageView_header);

        imageView_header.setColorFilter(ContextCompat.getColor(this, R.color.profile_default_tint));

    }


    private void loadProfile(String imagedata) {

        // Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
        GlideApp.with(this).load(imagedata)
                .into(imageView_header);
        imageView_header.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notification) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {

            item.setIcon(R.drawable.homewhite);

            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem1 = menu.getItem(2);
            menuItem1.setIcon(R.mipmap.document);
            MenuItem menuItem2 = menu.getItem(1);
            menuItem2.setIcon(R.mipmap.itinerarylogo);
            MenuItem menuItem = menu.getItem(3);
            menuItem.setIcon(R.mipmap.weather);

            Intent intent = new Intent(MainHomeActivity.this, MainHomeActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.navigation_acconts) {

            item.setIcon(R.mipmap.document);

            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem1 = menu.getItem(0);
            menuItem1.setIcon(R.drawable.homewhite);
            MenuItem menuItem2 = menu.getItem(1);
            menuItem2.setIcon(R.mipmap.itinerarylogo);
            MenuItem menuItem = menu.getItem(3);
            menuItem.setIcon(R.mipmap.weather);

            getSupportFragmentManager().beginTransaction().replace(R.id.main_container2, new DocumentFrag()).commit();
            m_frame3.setVisibility(View.GONE);
        } else if (id == R.id.navigation_bookings) {

            item.setIcon(R.mipmap.itinerarylogo);

            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem3 = menu.getItem(3);
            menuItem3.setIcon(R.mipmap.weather);
            MenuItem menuItem4 = menu.getItem(0);
            menuItem4.setIcon(R.drawable.homewhite);
            MenuItem menuItem5 = menu.getItem(2);
            menuItem5.setIcon(R.mipmap.document);

            getSupportFragmentManager().beginTransaction().replace(R.id.main_container2, new CurrentItineraryFragment()).commit();
            m_frame3.setVisibility(View.GONE);

        } else if (id == R.id.navigation_help) {
            item.setIcon(R.mipmap.weather);

            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem6 = menu.getItem(2);
            menuItem6.setIcon(R.mipmap.document);
            MenuItem menuItem7 = menu.getItem(0);
            menuItem7.setIcon(R.drawable.homewhite);
            MenuItem menuItem8 = menu.getItem(1);
            menuItem8.setIcon(R.mipmap.itinerarylogo);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container3, new WeatherFragment()).commit();
            m_frame3.setVisibility(View.VISIBLE);

        }

        else if (id == R.id.navigation_home) {

            item.setIcon(R.drawable.homegray);

            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem9 = menu.getItem(2);
            menuItem9.setIcon(R.drawable.accountwhite);
            MenuItem menuItem10 = menu.getItem(1);
            menuItem10.setIcon(R.drawable.mybookingwhite);
            MenuItem menuItem11 = menu.getItem(3);
            menuItem11.setIcon(R.drawable.helpwhite);
            Intent in=new Intent(MainHomeActivity.this,MainHomeActivity.class);
            startActivity(in);
        }

        else if (id == R.id.itinerary) {

            getSupportFragmentManager().beginTransaction().add(R.id.main_container2, new CurrentItineraryFragment()).addToBackStack("hdgh").commit();
        }

        else if (id == R.id.documents) {

            getSupportFragmentManager().beginTransaction().add(R.id.main_container2, new DocumentFrag()).addToBackStack("hdgh").commit();
        }

        else if (id == R.id.myaccount) {

            Intent intent = new Intent(MainHomeActivity.this, MainActivityProfile.class);
            startActivity(intent);
        }
        else if (id == R.id.logout) {

            opendialog();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void opendialog() {

            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Are you sure you want to Logout?");
            //  alertDialogBuilder.setTitle("Confirmation Required");
            alertDialogBuilder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                            SharedPreferences preferences1 = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
                            //    SharedPreferences preference = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("login_client", Context.MODE_PRIVATE);

                            SharedPreferences preferences = getApplicationContext().getSharedPreferences("updateclient", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor1 = preferences1.edit();

                            SharedPreferences.Editor editor = preferences.edit();
                            SharedPreferences.Editor editor2 = sharedPreferences.edit();

                            editor.clear();
                            editor1.clear();
                            editor2.clear();
                            editor.commit();
                            editor2.commit();
                            editor2.commit();


                            Intent intent=new Intent(MainHomeActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    });

            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();
                    //   progressBar.setVisibility(View.GONE);

                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }



    private int getSelectedItem(BottomNavigationView bottomNavigationView) {
        Menu menu = bottomNavigationView.getMenu();
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            if (menuItem.isChecked()) {
                return menuItem.getItemId();
            }
        }
        return 0;
    }

    @Override
    protected void onResume() {

        super.onResume();

        loadprofileimage();

    }

    @Override
    public void onListClick(ArrayList<HotelModel> results, int position) {
        Intent i=new Intent(MainHomeActivity.this,WebViewAct.class);
        i.putExtra("voucher",results);
        i.putExtra("position",position);
      //  ArrayList<HotelModel> hotelModels =results.get(position).getHotel();
        if(results!=null && results.size()>0)
        {
            startActivity(i);
        }

    }


    @Override
    public void onDemoClick(ArrayList<DayModel> result, int postion) {
        Intent i=new Intent(MainHomeActivity.this,CurrentItineraryFragment.class);
        i.putExtra("result",result);
        i.putExtra("position",postion);
        startActivity(i);
    }

    @Override
    public void onTransferClick(ArrayList<FlightModel> results, int postion) {
        Intent i=new Intent(MainHomeActivity.this,WebTransferIte.class);
        i.putExtra("voucher",results);
        i.putExtra("position",postion);
      //  ArrayList<FlightModel> flightModels =results.get(postion).getFlight();
        if(results!=null && results.size()>0)
        {
            startActivity(i);
        }
    }

    @Override
    public void onActivtiyClick(ArrayList<FlightModel> results, int postion) {
        Intent i=new Intent(MainHomeActivity.this,WebActivity.class);
        i.putExtra("voucher",results);
        i.putExtra("position",postion);
     //   ArrayList<HotelModel> hotelModels =results.get(postion).getHotel();
        if(results!=null && results.size()>0)
        {
            startActivity(i);
        }
    }

    @Override
    public void onEntranceClick(ArrayList<FlightModel> results, int postion) {
        Intent i=new Intent(MainHomeActivity.this,WebEntrance.class);
        i.putExtra("voucher",results);
        i.putExtra("position",postion);
     //   ArrayList<HotelModel> hotelModels =results.get(postion).getHotel();
        if(results!=null && results.size()>0)
        {
            startActivity(i);
        }
    }

    @Override
    public void onTransportClick(ArrayList<FlightModel> results, int postion) {
        Intent i=new Intent(MainHomeActivity.this,WebTransport.class);
        i.putExtra("voucher",results);
        i.putExtra("position",postion);
     //   ArrayList<FlightModel> flightModels  =results.get(postion).getFlight();
        if(results!=null && results.size()>0)
        {
            startActivity(i);
        }
    }


}
