package com.andexert.retrofitexample.rest;

import com.andexert.retrofitexample.rest.apiInterfaces.WeatherApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class Retired_RestClient {

    private static final String BASE_URL = "http://api.openweathermap.org/";
    private WeatherApi apiService;

    public Retired_RestClient() {
        Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
            .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(WeatherApi.class);
    }

    public WeatherApi getWeatherService() {
        return apiService;
    }
}
