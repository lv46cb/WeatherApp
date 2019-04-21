package com.example.nastase.weatherapp.Common;

import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    //API_KEY-ul este generat de catre serviciul Web pe baza unui user si al unei parole
    public static String API_KEY = "8ccd7eb4f13b33be6f8b1e19a82f821b";
    public static String API_LINK = "http://api.openweathermap.org/data/2.5/weather";

    //This function will create a functional link to the API path
    /*The @NotNull Annotation is, actually, an explicit contract declaring the following:
    A method should not return null.
    A variable (like fields, local variables, and parameters) cannot hold null value.*/
    @NonNull
    public static String apiRequest(String lat, String lon) {

        StringBuilder sb = new StringBuilder(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric",lat,lon,API_KEY));

        return sb.toString();
    }

    //This function will convert Unix time stamp to Date type with format "HH:mm"
    public  static String unixTimeStampToDateTime(double unixTimeStamp) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        date.setTime((long)unixTimeStamp*1000);

        return dateFormat.format(date);
    }

    //This function to get a link image from OpenWeatherMap
    public static String getImage(String icon) {
        return String.format("http://openweathermap.org/img/w/%s.png",icon);
    }

    //This function to get Date with format "dd MMMM yyyy HH:mm"
    public static String getDateNow() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
