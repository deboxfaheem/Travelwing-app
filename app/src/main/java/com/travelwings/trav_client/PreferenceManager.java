package com.travelwings.trav_client;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "uploaddoc";

    public PreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    }

    public void setIsLoggedIn0(boolean viewdelete) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGGED_IN_0, viewdelete);
        editor.apply();
    }
    public boolean isLooged0() {

        return pref.getBoolean(IS_LOGGED_IN_0, false);
    }

    public void setIsLoggedIn1(boolean viewdelete) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGGED_IN_1, viewdelete);
        editor.apply();
    }
    public boolean isLooged1() {

        return pref.getBoolean(IS_LOGGED_IN_1, false);
    }


    public void setIsLoggedIn2(boolean viewdelete) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGGED_IN_2, viewdelete);
        editor.apply();
    }
    public boolean isLooged2() {

        return pref.getBoolean(IS_LOGGED_IN_2, false);
    }


    public void setIsLoggedIn3(boolean viewdelete) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGGED_IN_3, viewdelete);
        editor.apply();
    }
    public boolean isLooged3() {

        return pref.getBoolean(IS_LOGGED_IN_3, false);
    }


    public void setIsLoggedIn4(boolean viewdelete) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGGED_IN_4, viewdelete);
        editor.apply();
    }
    public boolean isLooged4() {

        return pref.getBoolean(IS_LOGGED_IN_4, false);
    }


    public void setIsLoggedIn5(boolean viewdelete) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGGED_IN_5, viewdelete);
        editor.apply();
    }
    public boolean isLooged5() {

        return pref.getBoolean(IS_LOGGED_IN_5, false);
    }


    private static final String IS_LOGGED_IN_0 = "IsLoggedIn";
    private static final String IS_LOGGED_IN_1 = "IsLoggedIn1";
    private static final String IS_LOGGED_IN_2 = "IsLoggedIn2";
    private static final String IS_LOGGED_IN_3 = "IsLoggedIn3";
    private static final String IS_LOGGED_IN_4 = "IsLoggedIn4";
    private static final String IS_LOGGED_IN_5 = "IsLoggedIn5";
}
