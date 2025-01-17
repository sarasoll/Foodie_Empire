package com.example.foodieempire.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreference {
    private static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences("userData", Context.MODE_PRIVATE);
    }

    public static void writeToSharedPrefernce(Context context, String name, String phone, String mail) {
        getSharedPreference(context).edit().putString("name", name).apply();
        getSharedPreference(context).edit().putString("phone", phone).apply();
        getSharedPreference(context).edit().putString("mail", mail).apply();

    }

    public static void writeToSharedPrefernce(Context context, String name) {
        getSharedPreference(context).edit().putString("name", name).apply();


    }

    public static String getName(Context context) {
        return getSharedPreference(context).getString("name", "");
    }

    public static String getPhone(Context context) {
        return getSharedPreference(context).getString("phone", "");
    }

    public static String getMail(Context context) {
        return getSharedPreference(context).getString("mail", "");
    }
}
