package com.example.farrukhmalik.court_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreA ;
    int scoreB;

    public void teamA(int score){
        TextView t1 = (TextView) findViewById(R.id.scoreA);
        t1.setText(String.valueOf(scoreA));
    }

    public void teamB(int score){
        TextView t1 = (TextView) findViewById(R.id.scoreB);
        t1.setText(String.valueOf(scoreB));
    }


    public void plus3A(View view){
        scoreA = scoreA + 3;
        teamA(scoreA);
    }

    public void plus2A(View view){
        scoreA = scoreA + 2;
        teamA(scoreA);
    }

    public void freeThrowA(View view){
        scoreA = scoreA + 1;
        teamA(scoreA);
    }


    public void plus3B(View view){
        scoreB = scoreB + 3;
        teamB(scoreB);
    }

    public void plus2B(View view){
        scoreB = scoreB + 2;
        teamB(scoreB);
    }

    public void freeThrowB(View view){
        scoreB = scoreB + 1;
        teamB(scoreB);
    }




    public void reset(View view){
        scoreA = 0;
        scoreB = 0;
        teamA(scoreA);
        teamB(scoreB);
    }
}
