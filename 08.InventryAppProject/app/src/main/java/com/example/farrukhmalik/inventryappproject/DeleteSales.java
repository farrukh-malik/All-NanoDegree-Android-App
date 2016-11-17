package com.example.farrukhmalik.inventryappproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteSales extends AppCompatActivity {



    private static final String PRODUCT_TABLE = "SALES";
    private static final String SALES_ID = "SALE_ID";
    TextView txt;
    int id=-1;
    Button btn1,btn2;
    SQLiteDatabase sql;
    SqlLiteHandleClass cstm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_sales);
         txt= (TextView) findViewById(R.id.dltid);

        btn1 = (Button) findViewById(R.id.dltrow);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cstm = new SqlLiteHandleClass(getApplicationContext());
                sql = cstm.getWritableDatabase();
               try {
                   id = Integer.parseInt(txt.getText().toString());
                   sql.delete(PRODUCT_TABLE, SALES_ID + "=" + String.valueOf(id), null);
                   sql.close();
               }catch (Exception ex){
                   Toast.makeText(DeleteSales.this, ex.toString(), Toast.LENGTH_SHORT).show();
               }
            }
        });

        btn2= (Button) findViewById(R.id.dltall);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cstm = new SqlLiteHandleClass(getApplicationContext());
                sql = cstm.getWritableDatabase();
                sql.execSQL("DELETE FROM "+PRODUCT_TABLE);

                sql.close();

            }
        });


    }
}
