package com.travelwings.trav_client;

import android.app.Application;


public class WebServices extends Application {}


   /* List<InvoiceModel> Invoicelist;
    List<VoucherModel> Voucherlist;
    List<HistoryModel> Historylist;
    List<DocumentModel> Documentlist;
    ArrayList<Resultpas> resultpasArrayList;
    List<HolidaModel> Holidaylist;

    List<Model> Currentlist;

    DocumentsAdapter documentsAdapter;
    private static WebServices mInstance;



    @Override
    public void onCreate() {


        super.onCreate();
        mInstance = this;

    }

    public static WebServices getInstance() {
        return mInstance;
    }




    public void Profilelist() {


     //   Profilelist = new ArrayList<>();

       // ProfileFragment.progressBar.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        final String userid = sharedPreferences.getString("id", "");
        final String type = sharedPreferences.getString("type", "");
        final String mobile = sharedPreferences.getString("mobile", "");

        // Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();

        //getting the progressbar
        //making the progressbar visible
        //  progressBar .setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ClientTravApis.profile_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("mylog", response);
                //hiding the progressbar after completion
                //  progressBar.setVisibility(View.INVISIBLE);

         //       ProfileFragment.progressBar.setVisibility(View.GONE);


                try {
                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

                    JSONObject obj = new JSONObject(response);


                    Log.d("mylog", "jsonarray");
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object

                        SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("myprofile", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences1.edit();
                        //   editor.putBoolean("login_state",loginstate);
                        editor.putString("name", heroObject.getString("fullname"));
                        editor.putString("birthdate", heroObject.getString("birthDate"));
                        editor.putString("phonenumber", heroObject.getString("phoneNo"));
                        editor.putString("emailid", heroObject.getString("email"));
                        editor.putString("location",(heroObject.getString("stateId"))+", "+
                                heroObject.getString("country")+", "+
                                heroObject.getString("pinCode"));
                        editor.commit();

                        //      Profilelist.add(hero);


                    }


                    Log.d("mylog", "reachedBeforeAdapter");
                    //  InvoiceAdapter adapter = new InvoiceAdapter(getActivity(), Prof);
                    //adding the adapter to listview
                    //  InvoiceFragment.recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id",userid);
                params.put("type", type);
                params.put("mobile", mobile);


                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();

    }

    public void Documentlist(final FragmentActivity activity, final FragmentManager fragmentManager) {


        resultpasArrayList = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        final String userid = sharedPreferences.getString("id", "");
        final String type = sharedPreferences.getString("type", "");

        // Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();

        //getting the progressbar
        //making the progressbar visible
        //  progressBar .setVisibility(View.VISIBLE);

        //creating a string request to send request to the url

        String document_url="http://deboxglobal.co.in/travcrm-latestinbound/api/json_passportdetails.php?id=671&type=2";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, document_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("mylog", response);
                //hiding the progressbar after completion
                //  progressBar.setVisibility(View.INVISIBLE);

            //    DocumentsFragment.progressBar.setVisibility(View.GONE);


                try {


                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

  JSONObject obj = new JSONObject(response);


                    Log.d("mylog", "jsonarray");
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object


 DocumentModel hero = new DocumentModel(
                                heroObject.getString("id"),
                                heroObject.getString("documentType"),
                                heroObject.getString("documentNo"),
                                heroObject.getString("country"),
                                heroObject.getString("issueDate"),
                                heroObject.getString("expiryDate"));

                        Resultpas resultpas = new Resultpas(
                                heroObject.getString("id"),
                                heroObject.getString("documentType"),
                                heroObject.getString("documentNo"),
                                heroObject.getString("country"),
                                heroObject.getString("issueDate"),
                                heroObject.getString("expiryDate"));


                        resultpasArrayList.add(resultpas);



                    ResultPasResponseBean responseBean = ResultPasResponseBean.fromJson(response);
                    if (responseBean != null) {
                        if (responseBean.status.equals("true")) {
                            resultpasArrayList.addAll(responseBean.results);


                        }
                    }
                 documentsAdapter = new DocumentsAdapter(activity, resultpasArrayList,fragmentManager);

               //     recyclerView.setAdapter(documentsAdapter);
                    documentsAdapter.notifyDataSetChanged();

                    Log.d("mylog", "reachedBeforeAdapter");


                    // documentsAdapter.notifyDataSetChanged();

                    Log.e("mylog", "my resultpassarray is" + resultpasArrayList);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id","415");
                params.put("type", "2");


                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();

    }

    public void HolidayList(String url) {


        Holidaylist = new ArrayList<>();

        HolidayFragment.progressBar.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        final String userid = sharedPreferences.getString("id", "");
        final String type = sharedPreferences.getString("type", "");
        //    Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();

        //     SharedPreferences sharedPreferences = getActivity().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        //    final String userid = sharedPreferences.getString("id", "");
        //getting the progressbar
        //making the progressbar visible
        //  progressBar .setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("mylog", response);
                //hiding the progressbar after completion
                //  progressBar.setVisibility(View.INVISIBLE);

                HolidayFragment.progressBar.setVisibility(View.GONE);


                try {
                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

                    JSONObject obj = new JSONObject(response);



    String target=obj.getString("target");
                    String sales=obj.getString("sales");


                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("dashboard", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //   editor.putBoolean("login_state",loginstate);
                    editor.putString("target", target);
                    editor.putString("sales", sales);
                    //  editor.putString("Password", password);
                    editor.commit();


                    //  Toast.makeText(WebServices.this, target, Toast.LENGTH_SHORT).show();

                    //   ItemModel hero = new ItemModel(obj.getString("totalinr"),obj.getString("totalitems"));
                    //we have the array named hero inside the object
                    Log.d("mylog", "jsonarray");
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object
                        HolidayModel hero = new HolidayModel(
                                heroObject.getString("id"),
                                heroObject.getString("name"),
                                heroObject.getString("iconimage"),
                                heroObject.getString("status")


                        );


                        Holidaylist.add(hero);


                        //      Log.d("mylog",itemlist.toString());//adding the hero to herolist


                        //      Toast.makeText(getActivity(), todolist.toString(), Toast.LENGTH_SHORT).show();

                    }


                    Log.d("mylog", "reachedBeforeAdapter");
                    HolidayAdpater adapter1 = new HolidayAdpater(getApplicationContext(), Holidaylist);
                    //adding the adapter to listview
                    HolidayFragment.recyclerView.setAdapter(adapter1);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id", userid);
                params.put("type", type);
                params.put("mobile", "8958245482");


                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();


    }




    public void InvoiceList() {


        Invoicelist = new ArrayList<>();

        InvoiceFragment.progressBar.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
           final String userid = sharedPreferences.getString("id", "");
           final String type = sharedPreferences.getString("type", "");

       // Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();

        //getting the progressbar
        //making the progressbar visible
        //  progressBar .setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.POST, ClientTravApis.invoice_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("mylog", response);
                //hiding the progressbar after completion
                //  progressBar.setVisibility(View.INVISIBLE);

                InvoiceFragment.progressBar.setVisibility(View.GONE);


                try {
                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

                    JSONObject obj = new JSONObject(response);


            Log.d("mylog", "jsonarray");
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object
                        InvoiceModel hero = new InvoiceModel(
                                heroObject.getString("id"),
                                heroObject.getString("invoicename"),
                                heroObject.getString("invoicefullurl"),
                                heroObject.getString("mobilenumber"),
                                heroObject.getString("downloadpdf"),
                                heroObject.getString("invoicedate"),
                                heroObject.getString("invoicetype"),
                                heroObject.getString("client"),
                                heroObject.getString("finalCost"),
                                heroObject.getString("qid"));


                        Invoicelist.add(hero);


                    }


                    Log.d("mylog", "reachedBeforeAdapter");
                    InvoiceAdapter adapter = new InvoiceAdapter(getApplicationContext(), Invoicelist);
                    //adding the adapter to listview
                    InvoiceFragment.recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id",userid);
                params.put("type", type);


                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();

    }


    public void VoucherList() {


        Voucherlist = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        final String userid = sharedPreferences.getString("id", "");
        final String type = sharedPreferences.getString("type", "");
    //    Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();

        //     SharedPreferences sharedPreferences = getActivity().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        //    final String userid = sharedPreferences.getString("id", "");
        //getting the progressbar
        //making the progressbar visible
        //  progressBar .setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
 StringRequest stringRequest = new StringRequest(Request.Method.POST, ClientTravApis.voucher_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("mylog", response);
                //hiding the progressbar after completion
                //  progressBar.setVisibility(View.INVISIBLE);

                progressBar.setVisibility(View.GONE);


                try {
                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

                    JSONObject obj = new JSONObject(response);




    String target=obj.getString("target");
                    String sales=obj.getString("sales");


                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("dashboard", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //   editor.putBoolean("login_state",loginstate);
                    editor.putString("target", target);
                    editor.putString("sales", sales);
                    //  editor.putString("Password", password);
                    editor.commit();

                    //  Toast.makeText(WebServices.this, target, Toast.LENGTH_SHORT).show();

                    //   ItemModel hero = new ItemModel(obj.getString("totalinr"),obj.getString("totalitems"));
                    //we have the array named hero inside the object
                    Log.d("mylog", "jsonarray");
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object
                        VoucherModel hero = new VoucherModel(
                                heroObject.getString("id"),
                                heroObject.getString("bookingcode"),
                                heroObject.getString("voucherlink"),
                                heroObject.getString("mobilenumber"),
                                heroObject.getString("downloadvoucher"),
                                heroObject.getString("qid"),
                                heroObject.getString("packagevoucher"),
                                heroObject.getString("vouchertype"),
                                heroObject.getString("voucherdate")


                        );


                        Voucherlist.add(hero);


                        //      Log.d("mylog",itemlist.toString());//adding the hero to herolist


                        //      Toast.makeText(getActivity(), todolist.toString(), Toast.LENGTH_SHORT).show();

                    }


                    Log.d("mylog", "reachedBeforeAdapter");
                    VoucherAdapter adapter = new VoucherAdapter(getApplicationContext(), Voucherlist);
                    //adding the adapter to listview
                    VoucherFragment.recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id", userid);
                params.put("type", type);


                return params;
            }
        };



        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();


    }

    public void Historylist2() {



        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        final String userid = sharedPreferences.getString("id", "");
        final String type = sharedPreferences.getString("type", "");

        //   Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();


        Historylist = new ArrayList<>();

        RecommendedPackagesFragment.progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ClientTravApis.history_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("mylog", response);

                      RecommendedPackagesFragment.progressBar.setVisibility(View.GONE);


                try {
                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

                    JSONObject obj = new JSONObject(response);

                    Log.d("mylog", "jsonarray");
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object
                        HistoryModel hero = new HistoryModel(
                                heroObject.getString("queryid"),
                                heroObject.getString("subject"),
                                heroObject.getString("queryDate"),
                                heroObject.getString("adult"),
                                heroObject.getString("child"),
                                heroObject.getString("infant"),
                                heroObject.getString("itinaryfullurl")


                        );


                        Historylist.add(hero);


                    }


                    Log.d("mylog", "reachedBeforeAdapter");
                    HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(), Historylist);
                    //adding the adapter to listview
                    RecommendedPackagesFragment.recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id", userid);
                params.put("type", type);


                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();


    }





    public void Historylist() {



        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("loginfinal", Context.MODE_PRIVATE);
        final String userid = sharedPreferences.getString("id", "");
        final String type = sharedPreferences.getString("type", "");

     //   Toast.makeText(WebServices.this, userid+"gap"+type, Toast.LENGTH_SHORT).show();


        Historylist = new ArrayList<>();

        HistoryFragment.progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ClientTravApis.history_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("mylog", response);

                HistoryFragment.progressBar.setVisibility(View.GONE);


                try {
                    //getting the whole json object from the response
                    Log.d("mylog", "jsonobj");
                    Log.d("mylog", "reachedBeforeAdapter");

                    JSONObject obj = new JSONObject(response);

                    Log.d("mylog", "jsonarray");
                    JSONArray heroArray = obj.getJSONArray("results");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        Log.d("mylog", "jsonobj" + i);

                        JSONObject heroObject = heroArray.getJSONObject(i);
                        //creating a hero object and giving them the values from json object
                        HistoryModel hero = new HistoryModel(
                                heroObject.getString("queryid"),
                                heroObject.getString("subject"),
                                heroObject.getString("queryDate"),
                                heroObject.getString("adult"),
                                heroObject.getString("child"),
                                heroObject.getString("infant"),
                                heroObject.getString("itinaryfullurl")


                        );


                        Historylist.add(hero);


                    }


                    Log.d("mylog", "reachedBeforeAdapter");
                    HistoryAdapter adapter = new HistoryAdapter(getApplicationContext(), Historylist);
                    //adding the adapter to listview
                    HistoryFragment.recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Log.d("mylog", "Error_volley");
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getApplicationContext(),
                                    "no connection",
                                    Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {

                            Toast.makeText(getApplicationContext(),
                                    "Auth faliur",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ServerError) {

                            Toast.makeText(getApplicationContext(),
                                    "server error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof NetworkError) {

                            Toast.makeText(getApplicationContext(),
                                    "netrork error",
                                    Toast.LENGTH_LONG).show();
                            //TODO
                        } else if (error instanceof ParseError) {
                            Toast.makeText(getApplicationContext(),
                                    "parse error",
                                    Toast.LENGTH_LONG).show();
                            //displaying the error in toast if occurrs
                            // Log.d("mylog",error.getMessage().toString());
                            //  Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }


                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("id", userid);
                params.put("type", type);


                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);

        //   WebServices.getInstance();


    }
}}
*/