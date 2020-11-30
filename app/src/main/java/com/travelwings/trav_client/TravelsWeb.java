package com.travelwings.trav_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.travelwings.trav_client.AppConstants.AppNetworkConstants;

public class TravelsWeb extends AppCompatActivity {

  // String url="http://deboxglobal.co.in/travcrm-latestinbound/dirfiles/1595323449-Covid19-Countrywise-TravelAdvisories.pdf";
  String url= AppNetworkConstants.COVIDINTERNATIONAL;

    WebView m_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_web);
        m_webview = findViewById(R.id.trav_webview_WB);
        WebSettings ws=m_webview.getSettings();
        ws.setDomStorageEnabled(true);
        ws.setJavaScriptEnabled(true);

        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
        m_webview.requestFocus();
      //  m_webview.loadUrl("https://woodlandproplanet.co.in/mobileapp/styleperformance.php");


        m_webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + url);
    }
}