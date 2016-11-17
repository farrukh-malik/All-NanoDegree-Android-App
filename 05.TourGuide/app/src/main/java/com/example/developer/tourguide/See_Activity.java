package com.example.developer.tourguide;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class See_Activity extends AppCompatActivity {
    private PlacesAdapter adapter;
    private ArrayList<Placess> arrayList;
    private GridView gridview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_all);

        gridview = (GridView) findViewById(R.id.grid_view);

        arrayList = new ArrayList<>();
        arrayList.add(new Placess("Clifton Beach", "BeachViewPark,Arabian Sea,Sea View", "Karachi,Sindh Pakistan", R.drawable.clifton_beach));
        arrayList.add(new Placess("SandSpit Beach", "Sea View, Beach", "Karachi,Sindh Pakistan", R.drawable.sandspit_beach));
        arrayList.add(new Placess("Paradise Point", "Sea Viewm, Beach", "Karachi,Sindh Pakistan", R.drawable.paradisepoint_beach));
        arrayList.add(new Placess("French Beach", "Sea View, Beach", "Karachi,Sindh Paistan", R.drawable.french_beach));
        arrayList.add(new Placess("Neelam Point", "Sea View, Beach", " Karachi,Sindh Pakistan", R.drawable.neelamponit_beach));

        adapter = new PlacesAdapter(arrayList,this);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Placess place = arrayList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(See_Activity.this);
                builder.setTitle(place.getPlaceName());
                builder.setMessage(place.getDetails());
                View view1 = getLayoutInflater().inflate(R.layout.activity_large_view_image,null);
                ImageView im = (ImageView) view1.findViewById(R.id.large_view);
                im.setImageResource(place.getImageid());
                builder.setView(view1);
                builder.create().show();



            }
        });


    }
}
