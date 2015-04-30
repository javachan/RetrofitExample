package com.andexert.retrofitexample.rest.model;

import com.andexert.retrofitexample.model.Coord;
import com.andexert.retrofitexample.model.MainInfos;
import com.andexert.retrofitexample.model.Sys;
import com.andexert.retrofitexample.model.Weather;
import com.andexert.retrofitexample.model.Wind;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Author :    Chutaux Robin
 * Date :      10/2/2014
 */
@Parcel
public class ApiResponse
{
    @SerializedName("coord")
    private Coord coord;

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("weather")
    private ArrayList<Weather> weather;

    @SerializedName("main")
    private MainInfos mainInfos;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("name")
    private String strCityName;

    public Coord getCoord()
    {
        return coord;
    }

    public Sys getSys()
    {
        return sys;
    }

    public ArrayList<Weather> getWeather()
    {
        return weather;
    }

    public MainInfos getMainInfos()
    {
        return mainInfos;
    }

    public Wind getWind()
    {
        return wind;
    }

    public String getStrCityName()
    {
        return strCityName;
    }
}
