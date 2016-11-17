package com.example.farrukhmalik.inventryappproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Farrukh Malik on 10/22/2016.
 */
public class SqlLiteHandleClass extends SQLiteOpenHelper {

    private static final String DB_NAME="Record.db";



    private static final String PRODUCT_TABLE = "SALES";
    private static final String SALES_ID = "SALE_ID";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String SALE_QUANTITY = "SALE_QUANTIYT";
    private static final String SALE_PRICE = "SALE_PRICE";
    private static final String SALE_QUANTITYLEFT = "SALE_QUANTITYLEFT";

    private static final int VERSION_NAME=1;
    String tableQuery = "CREATE TABLE "+PRODUCT_TABLE+"("+SALES_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+PRODUCT_NAME+" Text,"+SALE_QUANTITY+" INTEGER, "+SALE_PRICE+" INTEGER ,"+SALE_QUANTITYLEFT+" INTEGER )";

    public SqlLiteHandleClass(Context context) {
        super(context, DB_NAME, null, VERSION_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tableQuery);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+PRODUCT_TABLE);

        onCreate(sqLiteDatabase);
    }
}
