package com.travelwings.trav_client;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.hanks.htextview.base.HTextView;

public class SplashActivity extends  AppCompatActivity {




    private static final long SPLASH_TIME_OUT =4000 ;
    ImageView logo;
    HTextView client_app;
    private int PERMISSION_REQUEST_CAMERA=0;
    private int STORAGE_PERMISSION_CODE = 101;
    private View mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mLayout = findViewById(R.id.my_layout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logo=findViewById(R.id.splash_logo);
        client_app=findViewById(R.id.client_app);
        client_app.setAnimationListener(new BaseActivity.SimpleAnimationListener(this));

        Animation nimSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.splash_anim_fade_in);

        Animation nimSlide2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.splash_anim_fade_out);

        client_app.animateText("CLIENT APP");
        //client_app.setAnimationListener(new SimpleAnimationListener(this));

        final AnimationSet s = new AnimationSet(false);//false means don't share interpolators
        final AnimationSet s1 = new AnimationSet(false);//false means don't share interpolators
        s.addAnimation(nimSlide);
        s1.addAnimation(nimSlide2);
        // s.addAnimation(nimSlide2);
   //    logo.startAnimation(s);

        //  logo.startAnimation(nimSlide);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over



                showinternetpermission();

                // logintoapp();



            }
        }, SPLASH_TIME_OUT);

    }


    private void logintoapp() {

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        SharedPreferences preferences = getApplication().getSharedPreferences("updateclient", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("id") ) {

            Intent i = new Intent(SplashActivity.this, MainHomeActivity.class);
            startActivity(i);
            finish();

        }
        else {

            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }

    private void showinternetpermission() {
        // BEGIN_INCLUDE(startCamera)
        // Check if the Camera permission has been granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                == PackageManager.PERMISSION_GRANTED) {
           // // Permission is already available, start camera preview
            Snackbar.make(mLayout,
                    R.string.camera_permission_available,
                    Snackbar.LENGTH_SHORT).show();
          //  Toast.makeText(this,"camera_permission_available", Toast.LENGTH_SHORT).show();
            logintoapp();
        } else {
            // Permission is missing and must be requested.
            askforinternet();
        }
        // END_INCLUDE(startCamera)
    }


    private void askforinternet() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.INTERNET)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with cda button to request the missing permission.
            Snackbar.make(mLayout, R.string.camera_access_required,
                    Snackbar.LENGTH_INDEFINITE).setAction(R.string.ok, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(SplashActivity.this,
                            new String[]{Manifest.permission.INTERNET},
                            PERMISSION_REQUEST_CAMERA);
                }
            }).show();

        } else {
            Snackbar.make(mLayout, R.string.camera_unavailable, Snackbar.LENGTH_SHORT).show();
            // Request the permission. The result will be received in onRequestPermissionResult().
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET}, PERMISSION_REQUEST_CAMERA);
        }



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // BEGIN_INCLUDE(onRequestPermissionsResult)
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            // Request for camera permission.
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start camera preview Activity.
                Snackbar.make(mLayout, R.string.camera_permission_granted,
                        Snackbar.LENGTH_SHORT)
                        .show();
                logintoapp();
            } else {
                // Permission request was denied.
                Snackbar.make(mLayout, R.string.camera_permission_denied,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }
        // END_INCLUDE(onRequestPermissionsResult)


    }







}
