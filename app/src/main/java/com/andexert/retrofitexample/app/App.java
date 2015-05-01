package com.andexert.retrofitexample.app;

import android.app.Application;

import com.andexert.retrofitexample.rest.ItemTypeAdapterFactory;
import com.andexert.retrofitexample.rest.RestApiDispencer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class App extends Application {
    private static RestApiDispencer restApiDispencer;

    @Override
    public void onCreate() {
        super.onCreate();

        restApiDispencer = new RestApiDispencer();
    }

    public static RestApiDispencer getRestApiDispencer() {
        return restApiDispencer;
    }
}
