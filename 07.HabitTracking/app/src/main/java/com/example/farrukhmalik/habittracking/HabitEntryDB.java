package com.example.farrukhmalik.habittracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Junaid on 10/23/2016.
 */

public class HabitEntryDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "HabitRecord";
    public static final String MONDAY = "Monday";
    public static final String TUESDAY = "Tuesday";
    public static final String WEDNESDAY = "Wednesday";
    public static final String THURSDAY = "Thursday";
    public static final String FRIDAY = "Friday";
    public static final String SATURDAY = "Saturday";
    public static final String SUNDAY = "Sunday";

    public static final String ID = "_id";

    public static final String HABIT = "Habit";

    String Query = "CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + HABIT + " TEXT,"

    +MONDAY+ " INTEGER DEFAULT 0," + TUESDAY+ " INTEGER DEFAULT 0," + WEDNESDAY+ " INTEGER DEFAULT 0,"+ THURSDAY+ " INTEGER DEFAULT 0," +
            FRIDAY+ " INTEGER DEFAULT 0," + SATURDAY+ " INTEGER DEFAULT 0," + SUNDAY+" INTEGER DEFAULT 0" + ")";

    public static final String DB_NAME = "HabitTrakking.db";
    public static final int version = 1;

    public HabitEntryDB(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);
    }
}
