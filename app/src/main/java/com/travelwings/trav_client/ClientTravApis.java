package com.travelwings.trav_client;

public class ClientTravApis  {

    public static String DEBOX_URL="http://deboxglobal.co.in/travcrm";
    public static String DEBOX_URL2="http://deboxcrm.com/crm";
    public static String FRONT_URL=DEBOX_URL2;
    public static String FRONT_URL3="http://deboxglobal.co.in";

    public static final String invoice_url1 = FRONT_URL+"/app/json/json_invoice.php";

    public static final String invoice_url =FRONT_URL+"/client_invoice.php";
    public static final String holiday_url =FRONT_URL+"/client_holidaypreference.php?mobile=9672008522&id=1&type=2";
    public static final String holiday_meal =FRONT_URL+"/clientapp/client_mealpreference.php?mobile=9672008522&id=1&type=2";
    public static final String holiday_accomodation =FRONT_URL+"/clientapp/client_accomodationpre.php?mobile=9672008522&id=1&type=2";
    public static final String holiday_physical =FRONT_URL+"/clientapp/client_physicalCondition.php?mobile=9672008522&id=1&type=2";
    public static final String profile_url =FRONT_URL+"/clientapp/client_profile.php";
    public static final String document_url =FRONT_URL+"/clientapp/client_document.php";
   // public static final String itinerary_url =FRONT_URL+"/clientapp/client_Itinerarydays.php";
   public static final String itinerary_url =FRONT_URL3+"/travcrm-latestinbound/api/json_itenerarydays.php?id=671&type=2";
    public static final String voucher_url=FRONT_URL+"/clientapp/client_voucher.php?id=2207&type=1";
    public static final String history_url=FRONT_URL+"/clientapp/client_Itenary.php?id=2126&type=1";
}
