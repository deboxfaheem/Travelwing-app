package com.travelwings.trav_client;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.travelwings.trav_client.Models.VoucherDatum;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.util.ArrayList;

public class PDFActivity extends AppCompatActivity {

    /* EditText m_title;
     TextView m_url;
     Button m_submit;*/
    Button m_submit,m_view;
    PDFView m_pdf;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

       /* m_url=findViewById(R.id.url_EDT);
        m_title=findViewById(R.id.tite_EDT);
        m_submit=findViewById(R.id.submit_BTN);

        m_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String url ="http://deboxglobal.co.in/travcrm-latestinbound/upload/1590758373hotelsvoucher.pdf";
                String title =m_title.getText().toString();
               DownloadURl(url,title);
            }
        });*/

        m_submit=findViewById(R.id.submit_BTN);
        m_view=findViewById(R.id.view_BTN);
        m_pdf=findViewById(R.id.pdf_VIEWER);

        m_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    DownloadPDFfromURL();
                Toast.makeText(PDFActivity.this,"Downloaded ", Toast.LENGTH_SHORT).show();

            }
        });

        m_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File pdffile =new File(Environment.getExternalStorageDirectory()+"/PDF DOWNLOAD/"+"voucher.pdf");
                if (!pdffile.exists()) {
                    Toast.makeText(PDFActivity.this,"File Not Download ", Toast.LENGTH_SHORT).show();
                } else {
                    viewPDF(pdffile);
                }
            }
        });
    }
    public void DownloadPDFfromURL(){
        ArrayList<VoucherDatum> numbersList = (ArrayList<VoucherDatum>) getIntent().getSerializableExtra("voucher");
        String name=numbersList.get(pos).getDownloadvoucher();
      //  String name="http://deboxglobal.co.in/travcrm-latestinbound/upload/1590758373hotelsvoucher.pdf";
        String url="voucher.pdf";
        new DownloaderPdf()
                .execute(name,url);
    }
    public void viewPDF(File file){

        m_pdf.fromUri(Uri.fromFile(file)).load();
    }
}














   /* public void DownloadURl(String url,String title)
    {
     DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
     String titletemp=title.replace("","_");
     request.setTitle(titletemp);

     if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB)
     {
         request.allowScanningByMediaScanner();
         request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

     }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,titletemp+".pdf");
       DownloadManager downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        request.setMimeType("application/pdf");
        request.allowScanningByMediaScanner();
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        downloadManager.enqueue(request);
    }*/
