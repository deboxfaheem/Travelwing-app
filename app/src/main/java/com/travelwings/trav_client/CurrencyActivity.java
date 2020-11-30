package com.travelwings.trav_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Map;

public class CurrencyActivity extends AppCompatActivity{

    public static BreakIterator data;


    String[] sendfull={"INDIAN RUPEE","US DOLLAR","BRITISH POUND","JAPANESE YEN","EURO","RUSSIAN RUBLE","POLISH ZLOTY","TURKISH LIRA",
            "NORWEGIAN KRONE","AUSTRALIAN DOLLAR","NEW ZEALAND DOLLAR","CANADIAN DOLLAR","SWISS FRANC","HONG KONG DOLLAR",
            "SINGAPORE DOLLAR","SWEDISH KRONA","MEXICON PESO","DANISH KRONE", "CHINESE YUAN","SOUTH AFRICAN RAND"};

    String[] recfull={"US DOLLAR","INDIAN RUPEE","BRITISH POUND","JAPANESE YEN","EURO","RUSSIAN RUBLE","POLISH ZLOTY","TURKISH LIRA",
            "NORWEGIAN KRONE","AUSTRALIAN DOLLAR","NEW ZEALAND DOLLAR","CANADIAN DOLLAR","SWISS FRANC","HONG KONG DOLLAR",
            "SINGAPORE DOLLAR","SWEDISH KRONA","MEXICON PESO","DANISH KRONE", "CHINESE YUAN","SOUTH AFRICAN RAND"};

    String[] senderarr = { "USD","INR", "GBP", "JPY", "EUR", "RUB","PLN","TRY","NOK","AUD","NZD","CAD","CHF","HKD","SGD","SEK","MXN","DKK","CNH","ZAR"};
  //  String[] recarr = { "INR","GBP", "JPY", "EUR", "RUB","PLN","TRY","NOK","AUD","NZD","CAD","CHF","HKD","SGD","SEK","MXN","DKK","CNH","ZAR","USD"};

//    String from,to,amount;
    String pair1,pair2,amount;
    TextView m_recamt;
  //  EditText m_sendcur, m_sendamt, m_reccur;
    EditText m_sendamt;
    ImageView m_butt;
    TextView m_sendtext,m_rectext;
    Spinner spiner_sen,spiner_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
       spiner_sen = (Spinner) findViewById(R.id.spinner_sen);
        spiner_rec = (Spinner) findViewById(R.id.spinner_rec);
       m_sendtext = findViewById(R.id.sendcur_CUR);
       m_rectext =  findViewById(R.id.reccur_CUR);
        m_recamt=findViewById(R.id.recamt_CUR);

        m_butt=findViewById(R.id.button_CUR);

        m_sendamt=findViewById(R.id.sendamt_CUR);
      /*  m_sendcur=findViewById(R.id.sendcur_CUR);
        m_reccur=findViewById(R.id.reccur_CUR);*/

        ArrayAdapter spinsenadp = new ArrayAdapter(this,R.layout.color_spinner_layout,sendfull);
        spinsenadp.setDropDownViewResource(R.layout.spinner_dropdown);
        spiner_sen.setAdapter(spinsenadp);

        ArrayAdapter spinrecadp = new ArrayAdapter(this,R.layout.color_spinner_white,recfull);
        spinrecadp.setDropDownViewResource(R.layout.spinner_dropdown);
        spiner_rec.setAdapter(spinrecadp);

        spiner_sen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //   from= parent.getItemAtPosition(position).toString();
             switch (position)
             {
                 case 0:
                     pair1="INR";
                     m_sendtext.setText(pair1);
                     break;

                 case 1:
                     pair1="USD";
                     m_sendtext.setText(pair1);
                     break;

                 case 2:
                     pair1="GBP";
                     m_sendtext.setText(pair1);
                     break;

                 case 3:
                     pair1="JPY";
                     m_sendtext.setText(pair1);
                     break;

                 case 4:
                     pair1="EUR";
                     m_sendtext.setText(pair1);
                     break;

                 case 5:
                     pair1="RUB";
                     m_sendtext.setText(pair1);
                     break;

                 case 6:
                     pair1="PLN";
                     m_sendtext.setText(pair1);
                     break;

                 case 7:
                     pair1="TRY";
                     m_sendtext.setText(pair1);
                     break;

                 case 8:
                     pair1="NOK";
                     m_sendtext.setText(pair1);
                     break;
                 case 9:
                     pair1="AUD";
                     m_sendtext.setText(pair1);
                     break;

                 case 10:
                     pair1="NZD";
                     m_sendtext.setText(pair1);
                     break;

                 case 11:
                     pair1="CAD";
                     m_sendtext.setText(pair1);
                     break;
                 case 12:
                     pair1="CHF";
                     m_sendtext.setText(pair1);
                     break;

                 case 13:
                     pair1="HKD";
                     m_sendtext.setText(pair1);
                     break;

                 case 14:
                     pair1="SGD";
                     m_sendtext.setText(pair1);
                     break;

                 case 15:
                     pair1="SEK";
                     m_sendtext.setText(pair1);
                     break;

                 case 16:
                     pair1="MXN";
                     m_sendtext.setText(pair1);
                     break;
                 case 17:
                     pair1="DKK";
                     m_sendtext.setText(pair1);
                     break;
                 case 18:
                     pair1="CNH";
                     m_sendtext.setText(pair1);
                     break;
                 case 19:
                     pair1="ZAR";
                     m_sendtext.setText(pair1);
                     break;
             }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spiner_rec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

              switch (position) {

                  case 0:
                      pair2="USD";
                      m_rectext.setText(pair2);
                      break;
                  case 1:
                      pair2="INR";
                      m_rectext.setText(pair2);
                      break;

                  case 2:
                      pair2="GBP";
                      m_rectext.setText(pair2);
                      break;

                  case 3:
                      pair2="JPY";
                      m_rectext.setText(pair2);
                      break;

                  case 4:
                      pair2="EUR";
                      m_rectext.setText(pair2);
                      break;

                  case 5:
                      pair2="RUB";
                      m_rectext.setText(pair2);
                      break;

                  case 6:
                      pair2="PLN";
                      m_rectext.setText(pair2);
                      break;

                  case 7:
                      pair2="TRY";
                      m_rectext.setText(pair2);
                      break;

                  case 8:
                      pair2="NOK";
                      m_rectext.setText(pair2);
                      break;
                  case 9:
                      pair2="AUD";
                      m_rectext.setText(pair2);
                      break;

                  case 10:
                      pair2="NZD";
                      m_rectext.setText(pair2);
                      break;

                  case 11:
                      pair2="CAD";
                      m_rectext.setText(pair2);
                      break;
                  case 12:
                      pair2="CHF";
                      m_rectext.setText(pair2);
                      break;

                  case 13:
                      pair2="HKD";
                      m_rectext.setText(pair2);
                      break;

                  case 14:
                      pair2="SGD";
                      m_rectext.setText(pair2);
                      break;

                  case 15:
                      pair2="SEK";
                      m_rectext.setText(pair2);
                      break;

                  case 16:
                      pair2="MXN";
                      m_rectext.setText(pair2);
                      break;
                  case 17:
                      pair2="DKK";
                      m_rectext.setText(pair2);
                      break;
                  case 18:
                      pair2="CNH";
                      m_rectext.setText(pair2);
                      break;
                  case 19:
                      pair2="ZAR";
                      m_rectext.setText(pair2);
                      break;


              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        m_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount=m_sendamt.getText().toString().trim();
                regDetail();
            }
        });
    }


    public void regDetail() {
     //   final String url = "https://api.finage.co.uk/convert?from="+from+"&to="+to+"&amount="+amount+"&apikey=API_KEYN6M14MUBV3WDOIFY31GUWAAS6S4KP6YJ";

        final String url ="https://fcsapi.com/api-v2/forex/converter?pair1="+pair1+"&pair2="+pair2+"&amount="+amount+"&access_key=K3ZjdODVU3M8KGA5VSRLx9T7UOx32uCNwW97NAArftPPgAcLIy";
        final RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("mylog", "your RegistrationDetail are :" + response);
                try {
                    queue.getCache().clear();

                    JSONObject  jo = new JSONObject(response);
                    JSONObject jo1 =(JSONObject)jo.getJSONObject("response");
                       String total =jo1.getString("total");

                  //   String error=jo.getString("error");
                    /*from=jo.getString("from");
                    to=jo.getString("to");
                    amount=jo.getString("amount");
                    String value=jo.getString("value");
*/
                    Log.e("MyLog", "FROMCUR: " + pair1);
                    Log.e("MyLog", "TOCUR: " + pair2);
                    Log.e("MyLog", "AMOUNT: " + amount);
                 //   Log.e("MyLog", "CURRENCY ERROR: " + error);
                  //  m_recamt.setText(value);

                    if(!pair1.equals(pair2) && !amount.equals("") && !amount.equals("0"))
                    {
                        m_recamt.setText(total);

                    }
                    else {
                        Toast.makeText(CurrencyActivity.this,"Please check currencies and try again",Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MyLog", "onResponse: Error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Toast.makeText(CurrencyActivity.this,"Please check currencies and try again",Toast.LENGTH_SHORT).show();
              Toast.makeText(CurrencyActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("pair1",pair1);
                params.put("pair2",pair2);
                params.put("amount",amount);

                Log.e("Mylog", "parameter Currencyfrom " + pair1);
                Log.e("Mylog", "parameter currencyTo " + pair2);
                Log.e("Mylog", "parameter amount " + amount);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
              //  params.put("Content-Type", "application/x-www-form-urlencoded");
              //  params.put("Content-Type", "application/json; charset=utf-8");
                return params;
            }
        };
        queue.add(stringRequest);
        queue.getCache().clear();
    }

}
