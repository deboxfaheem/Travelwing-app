package com.travelwings.trav_client;

import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.travelwings.trav_client.Models.DayModel;
import com.travelwings.trav_client.Models.FlightModel;
import com.travelwings.trav_client.Models.ItenaryModel;
import com.travelwings.trav_client.Models.Result;

import java.util.ArrayList;

public class WebActivity extends AppCompatActivity {

    WebView m_webview;
    int pos;
    Button m_submit;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        m_webview = findViewById(R.id.webview_WB);
        ArrayList<FlightModel> numbersList = (ArrayList<FlightModel>) getIntent().getSerializableExtra("voucher");
        pos = getIntent().getIntExtra("position", 0);
        name = numbersList.get(0).getVoucherUrl();;
        Log.e("mylog","name of webview "+name);

        m_submit=findViewById(R.id.submit_BTN);

        if(!name.equals(""))
        {
            WebSettings ws=m_webview.getSettings();
            ws.setDomStorageEnabled(true);
            ws.setJavaScriptEnabled(true);

            ws.setUseWideViewPort(true);
            ws.setLoadWithOverviewMode(true);
            m_webview.setWebViewClient(new WebActivity.MyWebViewClient());
            m_webview.requestFocus();
            m_webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url="+name);
        }
        else {
            Toast.makeText(WebActivity.this,"No Document Available Now ", Toast.LENGTH_SHORT).show();
        }


        m_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.equals(""))
                {
                    Toast.makeText(WebActivity.this,"No Document Available Now ", Toast.LENGTH_SHORT).show();
                }
                else {
                    DownloadPDFfromURL();
                    Toast.makeText(WebActivity.this, "Downloaded ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);

            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(WebActivity.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
        }
    }

    public void DownloadPDFfromURL(){
        ArrayList<FlightModel> numbersList = (ArrayList<FlightModel>) getIntent().getSerializableExtra("voucher");
        pos = getIntent().getIntExtra("position", 0);
        String name=numbersList.get(0).getVoucherUrl();
        //  String name="http://deboxglobal.co.in/travcrm-latestinbound/upload/1590758373hotelsvoucher.pdf";
        String url="voucher.pdf";
        new DownloaderPdf()
                .execute(name,url);
    }
    }
