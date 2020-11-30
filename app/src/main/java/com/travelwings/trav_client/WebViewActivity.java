package com.travelwings.trav_client;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {


    WebView webView;
    TextView nointernet;
    private int PERMISSION_REQUEST_CAMERA=0;
    private View mLayout;
    Bundle savedInstanceState;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        webView=findViewById(R.id.webview);
        progressBar=findViewById(R.id.progress_bar_webview);
        nointernet=findViewById(R.id.nointernt);

        Intent intent = getIntent();
        String url = intent.getStringExtra("itinerary_url");
        String urlpdf = intent.getStringExtra("pdf_url");



//        openwebview();

        checkConnection(savedInstanceState,url,urlpdf);



    }


    private void checkConnection(Bundle savedInstanceState, String url, String urlpdf) {

        {

            if(isInternetOn())
            {


                showinternetpermission(savedInstanceState,url,urlpdf);

                // Toast.makeText(MainActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();
            }
            else{


                SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString("SP_LAST_WEBVIEW_URL", webView.getUrl());
                editor.commit();
              //  Intent i = new Intent(MainActivity.this, NoInternetActivity.class);
                //startActivity(i);
                Toast.makeText(WebViewActivity.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }



    public final boolean isInternetOn()
    {
        ConnectivityManager connec = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // ARE WE CONNECTED TO THE NET
        if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED )
        {
            // MESSAGE TO SCREEN FOR TESTING (IF REQ)
            //Toast.makeText(this, connectionType + ” connected”, Toast.LENGTH_SHORT).show();
            return true;
        }
        else if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
                ||  connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  )
        {
            return false;
        }

        return false;
    }



    private void showinternetpermission(Bundle savedInstanceState, String url, String urlpdf) {

        // BEGIN_INCLUDE(startCamera)
        // Check if the Camera permission has been granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission is already available, start camera preview
            //   Snackbar.make(mLayout,
            //         R.string.camera_permission_available,
            //       Snackbar.LENGTH_SHORT).show();
            // logintoapp();
            checkinternet(savedInstanceState,url,urlpdf);
        } else {
            // Permission is missing and must be requested.
            askinternet();

        }
        // END_INCLUDE(startCamera)



    }

    private void askinternet()
    {

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
                    ActivityCompat.requestPermissions(WebViewActivity.this,
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

    public void checkinternet(Bundle savedInstanceState, String url, String urlpdf) {

        if(CheckNetwork.isInternetAvailable(WebViewActivity.this))
        {

            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {

                    if (progress == 100) {
                        progressBar.setVisibility(View.GONE);

                    } else {
                        progressBar.setVisibility(View.VISIBLE);

                    }
                    //  MainActivity.this.setProgress(progress * 1000);

                }
            });
            webView.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    //   Toast.makeText(MainActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                    view.loadData("<html>OMG! SOMETHING WENT WRONG!</html>", "", "");
                  //  Intent intent=new Intent(WebViewActivity.this,NoInternetActivity.class);
                   // startActivity(intent);
                   // finish();




                }

                @Override
                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    super.onReceivedHttpError(view, request, errorResponse);


                  //  opendialog();
                }
            });

            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            String savedUrl = sharedPref.getString("SP_LAST_WEBVIEW_URL",url);
         //   String savedUrl2 = sharedPref.getString("SP_LAST_WEBVIEW_URL",urlpdf);
            //   WebView webview = (WebView)findViewById(R.id.webview);
            if (savedInstanceState != null) {


                webView.restoreState(savedInstanceState);


            }
            else {

                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setUseWideViewPort(true);
                webView.getSettings().setBuiltInZoomControls(true);



                if(url==null){

                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.loadUrl("https://docs.google.com/viewer?url="+urlpdf);

                }
                else {

                    webView.loadUrl(savedUrl);
                }


            }
            //  webView.loadUrl("http://deboxglobal.co.in/demo/jmivecospace/");

        }
        else{
            //no connection
            Toast toast = Toast.makeText(WebViewActivity.this, "No Internet Connection", Toast.LENGTH_LONG);
            toast.show();
        }



    }


}



