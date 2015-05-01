package com.andexert.retrofitexample.app;

import android.app.Application;

import com.andexert.retrofitexample.rest.RestApiDispenser;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
public class App extends Application {
    private static RestApiDispenser restApiDispenser;

    @Override
    public void onCreate() {
        super.onCreate();

        restApiDispenser = new RestApiDispenser();
    }

    public static RestApiDispenser getRestApiDispenser() {
        return restApiDispenser;
    }
}
