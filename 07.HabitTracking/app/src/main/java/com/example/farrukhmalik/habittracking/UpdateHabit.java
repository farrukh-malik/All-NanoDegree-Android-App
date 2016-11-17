package com.example.farrukhmalik.habittracking;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateHabit extends AppCompatActivity {


    RadioButton[] rd;
    Button btn;
    TextView txt,txtId;

    String habit;
    int id;
    SQLiteDatabase db;
    HabitEntryDB hbd;
    ContentValues value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_habit);

    rd = new RadioButton[7];
        rd[0] = (RadioButton) findViewById(R.id.monu);
        rd[1] = (RadioButton) findViewById(R.id.tuesu);
        rd[2] = (RadioButton) findViewById(R.id.wedu);
        rd[3] = (RadioButton) findViewById(R.id.thuru);
        rd[4] = (RadioButton) findViewById(R.id.friu);
        rd[5] = (RadioButton) findViewById(R.id.satu);
        rd[6] = (RadioButton) findViewById(R.id.sunu);
        btn = (Button) findViewById(R.id.updt);
        hbd = new HabitEntryDB(this);
        db = hbd.getWritableDatabase();

        value = new ContentValues();
        txt = (TextView) findViewById(R.id.edit_text_upd);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rd[0].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 1);
                        value.put(HabitEntryDB.TUESDAY, 0);
                        value.put(HabitEntryDB.WEDNESDAY, 0);
                        value.put(HabitEntryDB.THURSDAY, 0);
                        value.put(HabitEntryDB.FRIDAY, 0);
                        value.put(HabitEntryDB.SATURDAY, 0);
                        value.put(HabitEntryDB.SUNDAY, 0);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }

                else if(rd[1].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 0);
                        value.put(HabitEntryDB.TUESDAY, 1);
                        value.put(HabitEntryDB.WEDNESDAY, 0);
                        value.put(HabitEntryDB.THURSDAY, 0);
                        value.put(HabitEntryDB.FRIDAY, 0);
                        value.put(HabitEntryDB.SATURDAY, 0);
                        value.put(HabitEntryDB.SUNDAY, 0);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }

                else if(rd[2].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 0);
                        value.put(HabitEntryDB.TUESDAY, 0);
                        value.put(HabitEntryDB.WEDNESDAY, 1);
                        value.put(HabitEntryDB.THURSDAY, 0);
                        value.put(HabitEntryDB.FRIDAY, 0);
                        value.put(HabitEntryDB.SATURDAY, 0);
                        value.put(HabitEntryDB.SUNDAY, 0);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }

                else if(rd[3].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 0);
                        value.put(HabitEntryDB.TUESDAY, 0);
                        value.put(HabitEntryDB.WEDNESDAY, 0);
                        value.put(HabitEntryDB.THURSDAY, 1);
                        value.put(HabitEntryDB.FRIDAY, 0);
                        value.put(HabitEntryDB.SATURDAY, 0);
                        value.put(HabitEntryDB.SUNDAY, 0);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }

                else if(rd[4].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 0);
                        value.put(HabitEntryDB.TUESDAY, 0);
                        value.put(HabitEntryDB.WEDNESDAY, 0);
                        value.put(HabitEntryDB.THURSDAY, 0);
                        value.put(HabitEntryDB.FRIDAY, 1);
                        value.put(HabitEntryDB.SATURDAY, 0);
                        value.put(HabitEntryDB.SUNDAY, 0);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }

                else if(rd[5].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 0);
                        value.put(HabitEntryDB.TUESDAY, 0);
                        value.put(HabitEntryDB.WEDNESDAY, 0);
                        value.put(HabitEntryDB.THURSDAY, 0);
                        value.put(HabitEntryDB.FRIDAY, 0);
                        value.put(HabitEntryDB.SATURDAY, 1);
                        value.put(HabitEntryDB.SUNDAY, 0);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }

                else if(rd[6].isChecked()){
                    try {
                        habit = txt.getText().toString().trim();
                        txtId = (TextView) findViewById(R.id.edit_id);
                        id = Integer.parseInt(txtId.getText().toString());

                        value.put(HabitEntryDB.HABIT, habit);
                        value.put(HabitEntryDB.MONDAY, 0);
                        value.put(HabitEntryDB.TUESDAY, 0);
                        value.put(HabitEntryDB.WEDNESDAY, 0);
                        value.put(HabitEntryDB.THURSDAY, 0);
                        value.put(HabitEntryDB.FRIDAY, 0);
                        value.put(HabitEntryDB.SATURDAY, 0);
                        value.put(HabitEntryDB.SUNDAY, 1);


                        db.update(HabitEntryDB.TABLE_NAME, value, HabitEntryDB.ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch (Exception ex){
                        Toast.makeText(UpdateHabit.this, ex.toString(), Toast.LENGTH_SHORT).show();

                    }

                }







            }
        });





    }
}
