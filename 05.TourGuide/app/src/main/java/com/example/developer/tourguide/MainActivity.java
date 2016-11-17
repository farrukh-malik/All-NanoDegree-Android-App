package com.example.developer.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView forhistory,seepoints,famous,beauty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forhistory = (TextView) findViewById(R.id.history);
        seepoints = (TextView) findViewById(R.id.seepoints);
        famous = (TextView) findViewById(R.id.famousplaces);
        beauty = (TextView) findViewById(R.id.beauty);



forhistory.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent call = new Intent(MainActivity.this,History_activity.class);
        startActivity(call);
    }
});
        seepoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(MainActivity.this,See_Activity.class);
                startActivity(call);
            }
        });
        famous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(MainActivity.this,Famous_Activity.class);
                startActivity(call);
            }
        });
        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(MainActivity.this,Beautiful_Activity.class);
                startActivity(call);
            }
        });
    }






}
