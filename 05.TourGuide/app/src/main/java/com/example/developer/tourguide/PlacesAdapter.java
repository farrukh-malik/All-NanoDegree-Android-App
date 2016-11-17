package com.example.developer.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Developer on 9/7/2016.
 */
public class PlacesAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<Placess> arraylist;
    private Context context;

    public PlacesAdapter(ArrayList<Placess> arraylist, Context context) {
        this.arraylist = arraylist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int pos) {
        return arraylist.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(int pos, View contentView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.single_view, null);


        TextView place_name = (TextView)view.findViewById(R.id.place_name);
        TextView place_details = (TextView)view.findViewById(R.id.place_details);
        TextView place_location = (TextView)view.findViewById(R.id.place_location);
        ImageView imgview = (ImageView) view.findViewById(R.id.place_imageview);

        Placess places = arraylist.get(pos);
        place_name.setText(places.getPlaceName());
        place_details.setText(places.getDetails());
        place_location.setText(places.getLocation());
        imgview.setImageResource(places.getImageid());
        return view;
    }
}
