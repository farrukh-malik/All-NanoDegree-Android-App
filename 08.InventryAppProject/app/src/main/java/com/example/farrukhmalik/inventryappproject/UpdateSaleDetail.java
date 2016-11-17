package com.example.farrukhmalik.inventryappproject;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateSaleDetail extends AppCompatActivity {



    private String pname;
    private int id=-1;
    private int price;
    private int quantity;
    private int stock;
    SQLiteDatabase db;
    SqlLiteHandleClass cstmSql;


    Button btn1,btn2,btn3,btn4,btn5;
    TextView id_table, nam, quant, prc, stk;




    private static final String PRODUCT_TABLE = "SALES";
    private static final String SALES_ID = "SALE_ID";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String SALE_QUANTITY = "SALE_QUANTIYT";
    private static final String SALE_PRICE = "SALE_PRICE";
    private static final String STOCK = "SALE_QUANTITYLEFT";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sale_detail);


        btn1 = (Button) findViewById(R.id.btnid);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id_table = (TextView) findViewById(R.id.pid);
                try {
                    id = Integer.parseInt(id_table.getText().toString());

                }catch (Exception ex){
                    Toast.makeText(UpdateSaleDetail.this, "please insert correct id", Toast.LENGTH_SHORT).show();
                    id_table.setText("");
                }

            }
        });

        btn2 = (Button) findViewById(R.id.btnname);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==-1){
                    Toast.makeText(UpdateSaleDetail.this, "Please insert id", Toast.LENGTH_SHORT).show();

                }
                else{
                    nam = (TextView) findViewById(R.id.nm);
                    cstmSql = new SqlLiteHandleClass(getApplicationContext());
                    SQLiteDatabase db = cstmSql.getWritableDatabase();
                    ContentValues value = new ContentValues();
                    value.put(PRODUCT_NAME,nam.getText().toString().trim());

                    db.update(PRODUCT_TABLE,value,SALES_ID+" = "+ String.valueOf(id),null);
                    db.close();

                }




            }
        });



        btn3 = (Button) findViewById(R.id.btnpr);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==-1){
                    Toast.makeText(UpdateSaleDetail.this, "Please insert id", Toast.LENGTH_SHORT).show();

                }
                else{
                    prc = (TextView) findViewById(R.id.nm);
                    cstmSql = new SqlLiteHandleClass(getApplicationContext());
                    SQLiteDatabase db = cstmSql.getWritableDatabase();
                    ContentValues value = new ContentValues();

                    try {
                        int price = Integer.parseInt(prc.getText().toString());

                        value.put(SALE_PRICE, price);

                        db.update(PRODUCT_TABLE, value, SALES_ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch(Exception ex){
                        Toast.makeText(UpdateSaleDetail.this, "Enter only Number", Toast.LENGTH_SHORT).show();

                    }


                }


            }
        });



        btn4 = (Button) findViewById(R.id.btnq);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==-1){
                    Toast.makeText(UpdateSaleDetail.this, "Please insert id", Toast.LENGTH_SHORT).show();

                }
                else{
                    prc = (TextView) findViewById(R.id.nm);
                    cstmSql = new SqlLiteHandleClass(getApplicationContext());
                    SQLiteDatabase db = cstmSql.getWritableDatabase();
                    ContentValues value = new ContentValues();
                    try {
                        int qty = Integer.parseInt(prc.getText().toString());

                        value.put(SALE_QUANTITY, qty);

                        db.update(PRODUCT_TABLE, value, SALES_ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch(Exception ex){
                        Toast.makeText(UpdateSaleDetail.this, "Enter only Number", Toast.LENGTH_SHORT).show();

                    }




                }
            }
        });


        btn5 = (Button) findViewById(R.id.btnstk);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==-1){
                    Toast.makeText(UpdateSaleDetail.this, "Please insert id", Toast.LENGTH_SHORT).show();

                }
                else{
                    prc = (TextView) findViewById(R.id.nm);
                    cstmSql = new SqlLiteHandleClass(getApplicationContext());
                    SQLiteDatabase db = cstmSql.getWritableDatabase();
                    ContentValues value = new ContentValues();
                    try {
                        int stk = Integer.parseInt(prc.getText().toString());

                        value.put(STOCK, price);

                        db.update(PRODUCT_TABLE, value, SALES_ID + " = " + String.valueOf(id), null);
                        db.close();
                    }catch(Exception ex){
                        Toast.makeText(UpdateSaleDetail.this, "Enter only Number", Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });





    }
}
