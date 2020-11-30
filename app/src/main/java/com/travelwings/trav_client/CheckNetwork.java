package com.travelwings.trav_client;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class CheckNetwork {

    private static final String TAG = CheckNetwork.class.getSimpleName();

    public static boolean isInternetAvailable(Context context)
    {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null)
        {
            Log.d(TAG,"no internet connection");
           //// Toast.makeText(context, "no internet connection", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            if(info.isConnected())
            {
                Log.d(TAG," internet connection available...");
              ////  Toast.makeText(context, "internet connection available...", Toast.LENGTH_SHORT).show();
                return true;
            }
            else
            {
                Log.d(TAG," internet connection");
              //  Toast.makeText(context, "internet connection", Toast.LENGTH_SHORT).show();

                return true;
            }

        }
    }
}
