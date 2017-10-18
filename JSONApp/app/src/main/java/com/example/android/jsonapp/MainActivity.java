package com.example.android.jsonapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EarthQuakeAsyncTask task = new EarthQuakeAsyncTask();
        task.execute();


    }

    private void DisplayResult(String jsonData) {
        ArrayList<EarthQuake> earthQuakes = EarthQuakeUtil.ExtractDat(jsonData);
        EarthQuakeArrayAdapter adapter = new EarthQuakeArrayAdapter(this, 0, earthQuakes);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    class EarthQuakeAsyncTask extends AsyncTask {

        @Override
        protected String doInBackground(Object[] objects) {
            StringBuilder JsonData = new StringBuilder();
            HttpURLConnection httpURLConnection = null;
            InputStream inputStream=null;
            try {
                URL url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    JsonData.append(line);
                    line = reader.readLine();
                }
                Log.v("AsyncTask", "Connected" + httpURLConnection.getResponseCode());
            } catch (Exception e) {
                e.printStackTrace();
                Log.v("AsyncTask", e.getMessage());
            }
            finally {
                if (httpURLConnection != null)
                    httpURLConnection.disconnect();
                if(inputStream!=null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }

            return JsonData.toString();
        }

        @Override
        protected void onPostExecute(Object o) {
            DisplayResult(o.toString());
        }
    }
}
