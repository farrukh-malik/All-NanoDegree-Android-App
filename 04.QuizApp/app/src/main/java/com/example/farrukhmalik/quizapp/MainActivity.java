package com.example.farrukhmalik.quizapp;

import android.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    int score=0;

    public void result(View view) {
        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);

        RadioButton rd1 = (RadioButton) findViewById(R.id.r1);
        if (rd1.isChecked()){
            score ++;
        }

        RadioButton rd2 = (RadioButton) findViewById(R.id.r2);
        if (rd2.isChecked()){
            score++;
        }

        if (score==2){
            msgBox.setMessage("Congratulation you got 100% marks..");
            msgBox.show();
        }

        else if (score==1){
            msgBox.setMessage("Good you got 50% marks..");
            msgBox.show();
        }

        else {
            msgBox.setMessage("Sorry! you are Failled 0% marks");
            msgBox.show();
        }
    }
}
