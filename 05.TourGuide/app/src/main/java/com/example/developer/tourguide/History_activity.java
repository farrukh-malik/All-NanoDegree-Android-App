package com.example.developer.tourguide;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class History_activity extends AppCompatActivity {
    private GridView listView;
    private ArrayList<Placess> arraylist;
    private PlacesAdapter common_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_all);

        listView = (GridView) findViewById(R.id.grid_view);
        arraylist = new ArrayList<>();
        arraylist.add(new Placess("Mohatta Palace", "Hindu Gymkhana,Nataional Treasure", "Karachi,Sind,Pakistan", R.drawable.mohatta_palace));
        arraylist.add(new Placess("Pakistan Maritime Museum", "Naval museum", "Karachi,Sind,Pakistan", R.drawable.maritime_museum));
        arraylist.add(new Placess("National Museum of Pakistan", "Victoria Museum, Frere Hall, Sir Bartle Frere", "Dr. Ziauddin Ahmed Road, Karachi, Pakistan", R.drawable.national_museum_of_pakistan));
        arraylist.add(new Placess("Wazir Mansion", "Museum, Jinnah House", "Karachi,Sind,Paistan", R.drawable.wazir_mansion));
        arraylist.add(new Placess("Chaukhandi tombs", "Tombs,", "Saddar, Karachi,Sind Pakistan", R.drawable.chaukhandi_tombs));
        common_adapter = new PlacesAdapter(arraylist, this);
        listView.setAdapter(common_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Placess place = arraylist.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(History_activity.this);
                builder.setTitle(place.getPlaceName());
                builder.setMessage(place.getDetails());
                View view1 = getLayoutInflater().inflate(R.layout.activity_large_view_image, null);
                ImageView imgView = (ImageView) view1.findViewById(R.id.large_view);
                imgView.setImageResource(place.getImageid());
                builder.setView(view1);

                builder.create().show();

            }
        });
    }
}
