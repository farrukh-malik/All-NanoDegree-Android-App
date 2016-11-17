package com.example.faiz.newsapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Faiz on 8/6/2016.
 */
public class SharedRef {

    private static String NAME = "packageName";
    private static String U_FNAME = "fname";
    private static String U_LNAME = "lanme";


    public static void setCurrentUser(Context context, News user) {
        SharedPreferences preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(U_FNAME, user.getTitle()).apply();
        preferences.edit().putString(U_LNAME, user.getNews()).apply();


    }

    public static News getCurrentUser(Context context) {
        News user = new News();
        SharedPreferences preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        user.setTitle(preferences.getString(U_FNAME, ""));
        user.setNews(preferences.getString(U_LNAME, ""));
        return user;
    }


}
