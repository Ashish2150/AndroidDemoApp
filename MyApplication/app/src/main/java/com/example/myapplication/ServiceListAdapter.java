package com.example.myapplication;

import static android.view.LayoutInflater.*;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ServiceListAdapter extends ArrayAdapter<String> {

    private String[] arr;
    public ServiceListAdapter(@NonNull Context context, int resource, @NonNull String[] arr) {
        super(context, resource, arr);
        this.arr = arr;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_layout, parent, false);

        if (convertView == null) {
            Log.d("debug", "getting null");
        }

        TextView t = convertView.findViewById(R.id.textView4);
        Log.d("debug", "getView: " + getItem(position));
        t.setText(getItem(position));

        return convertView;
    }
}
