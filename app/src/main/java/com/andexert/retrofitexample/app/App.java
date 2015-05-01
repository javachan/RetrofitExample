package com.andexert.retrofitexample.app;

import android.app.Application;

import com.andexert.retrofitexample.rest.ItemTypeAdapterFactory;
import com.andexert.retrofitexample.rest.RestApiDispencer;
import com.andexert.retrofitexample.rest.RetiredRestClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class App extends Application {
    private static RestAdapter restAdapter;
    private static RestApiDispencer restApiDispencer;

    @Override
    public void onCreate() {
        super.onCreate();

        createRestAdapter();
        restApiDispencer = new RestApiDispencer(restAdapter);
    }


    private void createRestAdapter() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(RestApiDispencer.BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();
    }


    public static RestAdapter getRestAdapter() {
        return restAdapter;
    }


    public static RestApiDispencer getRestApiDispencer() {
        return restApiDispencer;
    }
}
