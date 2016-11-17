package com.example.farrukhmalik.habittracking;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class InsertHabbit extends AppCompatActivity {


    RadioButton mon;
    RadioButton tue;
    RadioButton wed;
    RadioButton thu;
    RadioButton fri;
    RadioButton sat;
    RadioButton sun;
    Button btn;
    EditText et;
    SQLiteDatabase db;
    HabitEntryDB hDB;
    ContentValues values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_habbit);




        mon = (RadioButton) findViewById(R.id.mon);
        tue = (RadioButton) findViewById(R.id.tues);
        wed = (RadioButton) findViewById(R.id.wed);
        thu = (RadioButton) findViewById(R.id.thur);
        fri = (RadioButton) findViewById(R.id.fri);
        sat = (RadioButton) findViewById(R.id.sat);
        sun = (RadioButton) findViewById(R.id.sun);
        ///////////////////////////////////////
        btn = (Button) findViewById(R.id.submit);
        final EditText  edt= (EditText) findViewById(R.id.edit_text);




       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ///////////////////////



             //  Toast.makeText(getApplicationContext(), "called", Toast.LENGTH_SHORT).show();

               try{

                   values = new ContentValues();

                   hDB = new HabitEntryDB(getApplicationContext());
                   db = hDB.getWritableDatabase();
//
                   if(mon.isChecked()){

                       values.put(HabitEntryDB.MONDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);


                   }
                   else if(tue.isChecked()){
                       values.put(HabitEntryDB.TUESDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);

                   }
                   else if(wed.isChecked()){
                       values.put(HabitEntryDB.WEDNESDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);

                   }
                   else if(thu.isChecked()){
                       values.put(HabitEntryDB.THURSDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);

                   }
                   else if(fri.isChecked()){
                       values.put(HabitEntryDB.FRIDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);

                   }
                   else if(sat.isChecked()){
                       values.put(HabitEntryDB.SATURDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);

                   }
                   else if(sun.isChecked()){
                       values.put(HabitEntryDB.SUNDAY,1);
                       values.put(HabitEntryDB.HABIT,edt.getText().toString());
                       insertDb(values,db);

                   }
                   else {
                       Toast.makeText(getApplicationContext(), "Insert Habit", Toast.LENGTH_SHORT).show();
                   }
               }
               catch (Exception e){
                   Toast.makeText(InsertHabbit.this, e.toString(), Toast.LENGTH_SHORT).show();
               }






               //////////////////////////////
           }
       });

    }




    public void insertDb (ContentValues cv, SQLiteDatabase db){
        long flag = db.insert(HabitEntryDB.TABLE_NAME, null, cv);
        if(flag==-1){
            Toast.makeText(getApplicationContext(), "Not inserted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
