package com.example.farrukhmalik.habittracking;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.farrukhmalik.habittracking.ReadClass.ListAdapter;
import com.example.farrukhmalik.habittracking.ReadClass.ReadClass;

import java.util.ArrayList;

public class ReadHabbit extends AppCompatActivity {

    ListView list;
    ArrayList<ReadClass> arr;
    SQLiteDatabase sdb;
    HabitEntryDB hbt;
        int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_habbit);


        try {

            String text;
            int[] data = new int[7];

            hbt = new HabitEntryDB(this);
            list = (ListView) findViewById(R.id.list);

            arr = new ArrayList<ReadClass>();

            sdb = hbt.getReadableDatabase();
            Cursor c = sdb.rawQuery("SELECT * FROM " + HabitEntryDB.TABLE_NAME, null);

            while (c.moveToNext()) {
                for (int j = 0; j < data.length; j++) {
                    data[j] = 0;

                }
                int i = 0;

                text = Integer.parseInt(c.getString(c.getColumnIndex(HabitEntryDB.ID)))+".  "+ c.getString( c.getColumnIndex(HabitEntryDB.HABIT));

                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.MONDAY)));
                i++;
                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.TUESDAY)));
                i++;
                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.WEDNESDAY)));
                i++;
                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.THURSDAY)));
                i++;
                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.FRIDAY)));
                i++;
                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.SATURDAY)));
                i++;

                data[i] = Integer.parseInt(c.getString( c.getColumnIndex(HabitEntryDB.SUNDAY)));

                arr.add(new ReadClass(text, data));

                //i++;
            }//

            ListAdapter cstm = new ListAdapter(this, arr);
            list.setAdapter(cstm);

        }catch (Exception e){
            Toast.makeText(ReadHabbit.this, e.toString()+"  "+flag, Toast.LENGTH_SHORT).show();
            Log.d("Error",e.toString());
        }






    }
}
