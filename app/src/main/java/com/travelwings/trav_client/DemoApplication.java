package com.travelwings.trav_client;

import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by zfdang on 2016-4-15.
 */
public class DemoApplication extends WebServices
{
    @Override
    public void onCreate() {
        super.onCreate();

        // the following line is important
        Fresco.initialize(getApplicationContext());
    }
}
