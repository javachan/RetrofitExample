package com.andexert.retrofitexample.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by xiaolu on 4/30/15.
 */

/** Inspired by this post
 * http://stackoverflow.com/questions/25275106/where-to-attach-the-reference-to-a-retrofit-adapter-in-android
 */
public class RestApiDispencer {
    public static final String BASE_URL = "http://api.openweathermap.org/";

    // put all API "interfaces" into a hash map so that every interface is created only once
    private Map<String, Object> restApiInstances = new HashMap<String, Object>();

    private RestAdapter restAdapter;

    // restAdapter is treated as an argument for the constructor which implies that rest adater
    // can be a singleton class and be shared by all API interfaces
    public RestApiDispencer() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        this.restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(RestApiDispencer.BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();
    }


    public <T> T getRestApi(Class<T> apiClass) {
        T client = null;
        if ((client = (T) restApiInstances.get(apiClass.getCanonicalName())) != null) {
            return client;
        }
        client = restAdapter.create(apiClass);
        restApiInstances.put(apiClass.getCanonicalName(), client);
        return client;
    }
}
