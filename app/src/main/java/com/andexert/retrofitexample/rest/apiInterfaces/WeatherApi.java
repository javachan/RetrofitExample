package com.andexert.retrofitexample.rest.apiInterfaces;

import com.andexert.retrofitexample.rest.model.WeatherApiResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public interface WeatherApi {
    // http://api.openweathermap.org/data/2.5/weather?q=saratoga
    @GET("/data/2.5/weather")
    public void getWeather(@Query("q") String strCity, Callback<WeatherApiResponse> callback);
}
