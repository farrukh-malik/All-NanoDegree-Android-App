package com.example.farrukhmalik.inventryappproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ReadSaleDetail extends AppCompatActivity {

    SqlLiteHandleClass read;



    private static final String PRODUCT_TABLE = "SALES";
    private static final String SALES_ID = "SALE_ID";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String SALE_QUANTITY = "SALE_QUANTIYT";
    private static final String SALE_PRICE = "SALE_PRICE";
    private static final String STOCK = "SALE_QUANTITYLEFT";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_sale_detail);



        read = new SqlLiteHandleClass(this);
        SQLiteDatabase db = read.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+PRODUCT_TABLE,null);

        if(c.getCount()==0){
            ShowMessage("Error","NothingFound");
            return;
        }
        StringBuffer stb = new StringBuffer();
        while(c.moveToNext()){
            stb.append(SALES_ID+ " = "+  c.getString(0)+"\n\n");
            stb.append(PRODUCT_NAME+ " = "+  c.getString(1)+"\n\n");
            stb.append(SALE_QUANTITY+ " = "+  c.getString(2)+"\n\n");
            stb.append(STOCK+ " = "+ c.getString(3)+"\n\n");
            stb.append(SALE_PRICE+ " = "+  c.getString(4)+"\n\n--------------------------------\n\n");
        }
        ShowMessage("Data",stb.toString());






    }


    public void ShowMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
