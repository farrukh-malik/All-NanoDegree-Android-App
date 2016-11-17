package com.example.developer.tourguide;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Famous_Activity extends AppCompatActivity {

    private GridView gridView;
    private PlacesAdapter adapter;
    private ArrayList<Placess> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_all);

        gridView = (GridView) findViewById(R.id.grid_view);
        arraylist = new ArrayList<>();
        arraylist.add(new Placess("Quaid-Azam Tomb", "National Mausoleum,Jinnah Mausoleum", "Karachi,Sindh Pakistan", R.drawable.mazar_quaid));
        arraylist.add(new Placess("Pakistan Maritime Museum", "Naval museum", "Karachi,Sindh Pakistan", R.drawable.maritime_museum));
        arraylist.add(new Placess("National Museum of Pakistan", "Victoria Museum, Frere Hall, Sir Bartle Frere", "Dr. Ziauddin Ahmed Road, Karachi, Pakistan", R.drawable.national_museum_of_pakistan));
        arraylist.add(new Placess("Port-Grand", "Entertainment Complex,", "Karachi,Sindh Paistan", R.drawable.port_grand));
        arraylist.add(new Placess("Empress Market", "Market", "Saddar, Karachi,Sindh Pakistan", R.drawable.empress_market));

        adapter = new PlacesAdapter(arraylist,this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Placess places = arraylist.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(Famous_Activity.this);
                builder.setTitle(places.getPlaceName());
                builder.setMessage(places.getDetails());
                View view1 = getLayoutInflater().inflate(R.layout.activity_large_view_image,null);
                ImageView imview = (ImageView) view1.findViewById(R.id.large_view);
                imview.setImageResource(places.getImageid());
                builder.setView(view1);
                builder.create().show();

            }
        });


    }
}
