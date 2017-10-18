package com.example.android.jsonapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Shereen on 10/17/2017.
 */

public class EarthQuakeArrayAdapter extends ArrayAdapter<EarthQuake> {


    public EarthQuakeArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<EarthQuake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        EarthQuake item = getItem(position);
        TextView magTextView = (TextView) listItem.findViewById(R.id.mag_text_view);
        TextView distanceTextView = (TextView) listItem.findViewById(R.id.distannce_text_view);
        TextView placeTextView = (TextView) listItem.findViewById(R.id.place_text_view);
        TextView dateTextView = (TextView) listItem.findViewById(R.id.date_text_view);
        TextView timeTextView = (TextView) listItem.findViewById(R.id.time_text_view);
        DecimalFormat df=new DecimalFormat("#0.0");
        magTextView.setText(df.format(item.getMagnitude()) + "");
        int index = item.getPlace().indexOf(" of ");

        distanceTextView.setText(item.getPlace().substring(0, index + 3));
        placeTextView.setText(item.getPlace().substring(index + 4));
        Date date = new Date(item.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        dateTextView.setText(dateFormat.format(date));
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        timeTextView.setText(timeFormat.format(date));
        return listItem;
    }
}
