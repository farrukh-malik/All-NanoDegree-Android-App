package com.example.developer.miwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openNumbersList(View view){
        Intent i = new Intent(this, Numbers.class);
        startActivity(i);
    }
    public void openFamilyList(View view){
        Intent i = new Intent(this, Family.class);
       startActivity(i);
    }
    public void openColorList(View view){
        Intent i = new Intent(this, Colors.class);
        startActivity(i);
    }
    public void openPhraseList(View view){
        Intent i = new Intent(this, Phrase.class);
        startActivity(i);
    }
}
