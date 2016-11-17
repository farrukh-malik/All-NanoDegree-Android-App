package com.example.farrukhmalik.habittracking;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {



    SQLiteDatabase db;
    Button btn1,btn2;
    EditText txt;
    int id;
    HabitEntryDB cstmdb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        cstmdb = new HabitEntryDB(this);


        btn1= (Button) findViewById(R.id.dltr);
        btn2= (Button) findViewById(R.id.dltall);
        db=cstmdb.getWritableDatabase();
        txt = (EditText) findViewById(R.id.idd);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    id = Integer.parseInt(txt.getText().toString());
                    db.delete(HabitEntryDB.TABLE_NAME, id + "=" + String.valueOf(HabitEntryDB.ID), null);
                    Toast.makeText(DeleteActivity.this, "Deleted Row", Toast.LENGTH_SHORT).show();
                    db.close();



                }catch (Exception e){

                    Toast.makeText(DeleteActivity.this, e.toString(), Toast.LENGTH_SHORT).show();

                }


            }
        });

    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            db.execSQL("DELETE FROM "+HabitEntryDB.TABLE_NAME);
            Toast.makeText(DeleteActivity.this, "Deleted All", Toast.LENGTH_SHORT).show();
        }
    });


    }
}
