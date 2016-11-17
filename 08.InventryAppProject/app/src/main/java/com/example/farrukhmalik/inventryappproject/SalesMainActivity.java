package com.example.farrukhmalik.inventryappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalesMainActivity extends AppCompatActivity {
Button ins, read, upd, delt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_main);


        ins = (Button) findViewById(R.id.insert);


        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),InsertionSaleDetail.class));
            }
        });

        read = (Button) findViewById(R.id.read);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ReadSaleDetail.class));
            }
        });



        upd = (Button) findViewById(R.id.mnupdate);
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(),UpdateSaleDetail.class));
            }
        });


        delt = (Button) findViewById(R.id.delete);
        delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DeleteSales.class));
            }
        });


    }
}
