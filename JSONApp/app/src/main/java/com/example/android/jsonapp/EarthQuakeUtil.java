package com.example.android.jsonapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Shereen on 10/17/2017.
 */

public class EarthQuakeUtil {
    public static ArrayList<EarthQuake> ExtractDat(String jsonData){
        ArrayList<EarthQuake> earthQuakes=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("features");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                JSONObject properties = item.getJSONObject("properties");
                String place= properties.getString("place");
                double mag= properties.getDouble("mag");
                long time= properties.getLong("time");

                EarthQuake eq=new EarthQuake(place,mag,time);
                earthQuakes.add(eq);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.v("EarthQuack",e.getMessage());
        }
        return earthQuakes;
    }
}
