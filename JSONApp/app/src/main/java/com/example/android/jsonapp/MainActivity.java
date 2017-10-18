package com.example.android.jsonapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String jsonData = "{\n" +
                "  \"type\": \"FeatureCollection\",\n" +
                "  \"metadata\": {\n" +
                "    \"generated\": 1508237335000,\n" +
                "    \"url\": \"https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson\",\n" +
                "    \"title\": \"USGS All Earthquakes, Past Hour\",\n" +
                "    \"status\": 200,\n" +
                "    \"api\": \"1.5.8\",\n" +
                "    \"count\": 4\n" +
                "  },\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"mag\": 0.1,\n" +
                "        \"place\": \"53km ESE of Beatty, Nevada\",\n" +
                "        \"time\": 1508236792090,\n" +
                "        \"updated\": 1508236871836,\n" +
                "        \"tz\": -480,\n" +
                "        \"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/nn00609554\",\n" +
                "        \"detail\": \"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/nn00609554.geojson\",\n" +
                "        \"felt\": null,\n" +
                "        \"cdi\": null,\n" +
                "        \"mmi\": null,\n" +
                "        \"alert\": null,\n" +
                "        \"status\": \"automatic\",\n" +
                "        \"tsunami\": 0,\n" +
                "        \"sig\": 0,\n" +
                "        \"net\": \"nn\",\n" +
                "        \"code\": \"00609554\",\n" +
                "        \"ids\": \",nn00609554,\",\n" +
                "        \"sources\": \",nn,\",\n" +
                "        \"types\": \",geoserve,origin,phase-data,\",\n" +
                "        \"nst\": 9,\n" +
                "        \"dmin\": 0.13,\n" +
                "        \"rms\": null,\n" +
                "        \"gap\": 112.86,\n" +
                "        \"magType\": \"ml\",\n" +
                "        \"type\": \"earthquake\",\n" +
                "        \"title\": \"M 0.1 - 53km ESE of Beatty, Nevada\"\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          -116.2542,\n" +
                "          36.6482,\n" +
                "          16.6\n" +
                "        ]\n" +
                "      },\n" +
                "      \"id\": \"nn00609554\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"mag\": 0.8,\n" +
                "        \"place\": \"14km NNE of North Pole, Alaska\",\n" +
                "        \"time\": 1508235720159,\n" +
                "        \"updated\": 1508236102809,\n" +
                "        \"tz\": -540,\n" +
                "        \"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/ak17063159\",\n" +
                "        \"detail\": \"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/ak17063159.geojson\",\n" +
                "        \"felt\": null,\n" +
                "        \"cdi\": null,\n" +
                "        \"mmi\": null,\n" +
                "        \"alert\": null,\n" +
                "        \"status\": \"automatic\",\n" +
                "        \"tsunami\": 0,\n" +
                "        \"sig\": 10,\n" +
                "        \"net\": \"ak\",\n" +
                "        \"code\": \"17063159\",\n" +
                "        \"ids\": \",ak17063159,\",\n" +
                "        \"sources\": \",ak,\",\n" +
                "        \"types\": \",geoserve,origin,\",\n" +
                "        \"nst\": null,\n" +
                "        \"dmin\": null,\n" +
                "        \"rms\": 0.5,\n" +
                "        \"gap\": null,\n" +
                "        \"magType\": \"ml\",\n" +
                "        \"type\": \"earthquake\",\n" +
                "        \"title\": \"M 0.8 - 14km NNE of North Pole, Alaska\"\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          -147.26,\n" +
                "          64.8724,\n" +
                "          4.5\n" +
                "        ]\n" +
                "      },\n" +
                "      \"id\": \"ak17063159\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"mag\": 2.05,\n" +
                "        \"place\": \"17km NE of Olancha, CA\",\n" +
                "        \"time\": 1508235520200,\n" +
                "        \"updated\": 1508235738772,\n" +
                "        \"tz\": -480,\n" +
                "        \"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/ci38026616\",\n" +
                "        \"detail\": \"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/ci38026616.geojson\",\n" +
                "        \"felt\": null,\n" +
                "        \"cdi\": null,\n" +
                "        \"mmi\": null,\n" +
                "        \"alert\": null,\n" +
                "        \"status\": \"automatic\",\n" +
                "        \"tsunami\": 0,\n" +
                "        \"sig\": 65,\n" +
                "        \"net\": \"ci\",\n" +
                "        \"code\": \"38026616\",\n" +
                "        \"ids\": \",ci38026616,\",\n" +
                "        \"sources\": \",ci,\",\n" +
                "        \"types\": \",geoserve,nearby-cities,origin,phase-data,\",\n" +
                "        \"nst\": 24,\n" +
                "        \"dmin\": 0.1757,\n" +
                "        \"rms\": 0.18,\n" +
                "        \"gap\": 107,\n" +
                "        \"magType\": \"ml\",\n" +
                "        \"type\": \"earthquake\",\n" +
                "        \"title\": \"M 2.1 - 17km NE of Olancha, CA\"\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          -117.8698333,\n" +
                "          36.394,\n" +
                "          0.42\n" +
                "        ]\n" +
                "      },\n" +
                "      \"id\": \"ci38026616\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"mag\": 5,\n" +
                "        \"place\": \"86km NW of Nuku`alofa, Tonga\",\n" +
                "        \"time\": 1508234027880,\n" +
                "        \"updated\": 1508235315040,\n" +
                "        \"tz\": -720,\n" +
                "        \"url\": \"https://earthquake.usgs.gov/earthquakes/eventpage/us1000at83\",\n" +
                "        \"detail\": \"https://earthquake.usgs.gov/earthquakes/feed/v1.0/detail/us1000at83.geojson\",\n" +
                "        \"felt\": null,\n" +
                "        \"cdi\": null,\n" +
                "        \"mmi\": null,\n" +
                "        \"alert\": null,\n" +
                "        \"status\": \"reviewed\",\n" +
                "        \"tsunami\": 0,\n" +
                "        \"sig\": 385,\n" +
                "        \"net\": \"us\",\n" +
                "        \"code\": \"1000at83\",\n" +
                "        \"ids\": \",us1000at83,\",\n" +
                "        \"sources\": \",us,\",\n" +
                "        \"types\": \",geoserve,origin,phase-data,\",\n" +
                "        \"nst\": null,\n" +
                "        \"dmin\": 5.587,\n" +
                "        \"rms\": 1.56,\n" +
                "        \"gap\": 39,\n" +
                "        \"magType\": \"mb\",\n" +
                "        \"type\": \"earthquake\",\n" +
                "        \"title\": \"M 5.0 - 86km NW of Nuku`alofa, Tonga\"\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          -175.6702,\n" +
                "          -20.489,\n" +
                "          172.4\n" +
                "        ]\n" +
                "      },\n" +
                "      \"id\": \"us1000at83\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bbox\": [\n" +
                "    -175.6702,\n" +
                "    -20.489,\n" +
                "    0.42,\n" +
                "    -116.2542,\n" +
                "    64.8724,\n" +
                "    172.4\n" +
                "  ]\n" +
                "}";


        ArrayList<EarthQuake> earthQuakes = EarthQuakeUtil.ExtractDat(jsonData);
        EarthQuakeArrayAdapter adapter = new EarthQuakeArrayAdapter(this, 0, earthQuakes);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
}
