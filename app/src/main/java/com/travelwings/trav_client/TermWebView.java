package com.travelwings.trav_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class TermWebView extends AppCompatActivity {

    WebView m_webview;

   // String url="https://www.deboxglobal.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_web_view);
        m_webview = findViewById(R.id.trav_webview_WB);

        WebSettings ws = m_webview.getSettings();
        ws.setDomStorageEnabled(true);
        ws.setJavaScriptEnabled(true);

        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
        m_webview.requestFocus();
        //  m_webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + url1);
       // m_webview.loadUrl("file:///android_asset/myterm.html");
        m_webview.loadUrl("http://tw-worldwideholidays.com/live/privacy-policy.html");

    }
}