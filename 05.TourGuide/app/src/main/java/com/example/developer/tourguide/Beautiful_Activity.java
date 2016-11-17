package com.example.developer.tourguide;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Beautiful_Activity extends AppCompatActivity {

    private GridView gridView;
    private PlacesAdapter adapter;
    private ArrayList<Placess> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_all);

        gridView = (GridView) findViewById(R.id.grid_view);
        arraylist = new ArrayList<>();
        arraylist.add(new Placess("Karachi Golf Club", "Club", "Karachi,Sindh Pakistan", R.drawable.golfclub_beautiful));
        arraylist.add(new Placess("Jheel Park", "Park, Garden, Beauty", "Karachi,Sindh Pakistan", R.drawable.jeheelpark_beautiful));
        arraylist.add(new Placess("Karachi Zoo", "Entertainment, Zoo, Park", "Karachi,Sindh Paistan", R.drawable.zoo_beautiful));
        arraylist.add(new Placess("Manora, Karachi", "Island, Port", "Karachi,Sindh Pakistan", R.drawable.manora_beautiful));


        adapter = new PlacesAdapter(arraylist,this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Placess places = arraylist.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(Beautiful_Activity.this);
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
