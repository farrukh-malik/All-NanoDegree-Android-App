package com.example.farrukhmalik.inventryappproject;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InsertionSaleDetail extends AppCompatActivity {

    //3 int //1 string
    private String pname;

    private int price;
    private int quantity;
    private int stock;
    SQLiteDatabase db;
    SqlLiteHandleClass cstmSql;


    Button submit;
    TextView nam, quant, prc, stk;




    private static final String PRODUCT_TABLE = "SALES";
    private static final String SALES_ID = "SALE_ID";
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String SALE_QUANTITY = "SALE_QUANTIYT";
    private static final String SALE_PRICE = "SALE_PRICE";
    private static final String STOCK = "SALE_QUANTITYLEFT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sale_detail);

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try{

                nam = (TextView) findViewById(R.id.pname);
                pname = nam.getText().toString().trim();


                quant = (TextView) findViewById(R.id.pQuantity);
                quantity = Integer.parseInt(quant.getText().toString());

                prc = (TextView) findViewById(R.id.pPrice);
                price = Integer.parseInt(prc.getText().toString());


                stk = (TextView) findViewById(R.id.pStock);
                stock = Integer.parseInt(stk.getText().toString());


                cstmSql = new SqlLiteHandleClass(getApplicationContext());

                db = cstmSql.getWritableDatabase();

                ContentValues cont = new ContentValues();
                cont.put(PRODUCT_NAME,pname);
                cont.put(SALE_QUANTITY,quantity);
                cont.put(SALE_PRICE,price);
                cont.put(STOCK,stock);
               long flag =  db.insert(PRODUCT_TABLE,null,cont);
                if(flag==-1) {
                    Toast.makeText(InsertionSaleDetail.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(InsertionSaleDetail.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
                nam.setText("");
                quant.setText("");
                prc.setText("");
                stk.setText("");



            }  catch (Exception ex){

                Toast.makeText(InsertionSaleDetail.this, "Enter Valid Number", Toast.LENGTH_SHORT).show();

            }






            }
        });






    }
}
