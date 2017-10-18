package com.example.android.jsonapp;

/**
 * Created by Shereen on 10/17/2017.
 */

public class EarthQuake {
    private String place;
    private double magnitude;
    private long time;

    public EarthQuake(String place, double magnitude, long time) {
        this.place = place;
        this.magnitude = magnitude;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
