package com.example.prototype_1_group_12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Route> {

    private int layout;
    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull List<Route> objects) {
        super(context, resource, objects);
        layout = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout,null);

        }
        TextView txtName = convertView.findViewById(R.id.txtRouteName);
        TextView txtDate = convertView.findViewById(R.id.txtDate);
        TextView txtgps = convertView.findViewById(R.id.txtGps);
        TextView txtTags = convertView.findViewById(R.id.txtTags);

        txtName.setText(getItem(position).getRname());
        txtDate.setText(getItem(position).getDate());
        txtgps.setText(getItem(position).getGps());
        txtTags.setText(getItem(position).getTags());


        return convertView;
    }
}
