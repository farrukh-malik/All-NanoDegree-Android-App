package com.example.faiz.bookread;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ListView booksList;
    private  TextView responseText;
    static final String API_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private ImageView imageView;
    private ArrayList<Book> bookss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksList = (ListView) findViewById(R.id.books_list);
        responseText = (TextView) findViewById(R.id.txt_response);
        responseText.setVisibility(View.VISIBLE);

        final EditText searchEditText = (EditText) findViewById(R.id.search_edit_text);
        final Button searchButton = (Button) findViewById(R.id.btn_search);
        imageView = (ImageView)findViewById(R.id.bookImageCover);


        bookss=new ArrayList<Book>();
     //   imageView.setVisibility(View.VISIBLE);
        assert searchButton != null;
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = searchEditText.getText().toString();
                if (keyword.equals("")) {
                    responseText.setText("Please enter a Book Name.");
                    responseText.setVisibility(View.VISIBLE);
                    booksList.setVisibility(View.GONE);
                } else {
                    imageView.setVisibility(View.GONE);
                    new fetchBooksList().execute(API_URL + keyword);

                }
            }
        });




    }
    private class fetchBooksList extends AsyncTask<String, Void, String> {



        MainActivity activity=null;
       ArrayList<Book> books = new ArrayList<Book>();



        @Override
        protected  String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == 200) {
                    InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                    StringBuilder builder = new StringBuilder();

                    String inputString;
                    while ((inputString = bufferedReader.readLine()) != null) {
                        builder.append(inputString);
                    }

                    JSONObject rootObject = new JSONObject(builder.toString());
                    JSONArray bookItems = rootObject.getJSONArray("items");

                    for (int i = 0; i < bookItems.length(); i++) {
                        JSONObject bookItem = bookItems.getJSONObject(i);
                        JSONObject voluemInfo = bookItem.getJSONObject("volumeInfo");

                        // get the booktitle
                        String title = voluemInfo.getString("title");

                        // get the book authors
                        JSONArray authorsObject = voluemInfo.getJSONArray("authors");
                        String[] authors = new String[authorsObject.length()];
                        for (int j = 0; j < authorsObject.length(); j++) {
                            authors[j] = authorsObject.getString(j);

                        }



                        JSONObject image = voluemInfo.getJSONObject("imageLinks");
                        Log.d("images",image.toString());
                        String imageURL = image.getString("smallThumbnail");
                        Log.d("ImageURL",imageURL);

                        // create Book object
                        books.add(new Book(title, authors,imageURL));



                        urlConnection.disconnect();
                    }


                } else {

                    urlConnection.disconnect();
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (books.size() == 0) {
                        responseText.setVisibility(View.VISIBLE);
                    } else {

                        responseText.setVisibility(View.GONE);
                        booksList.setVisibility(View.VISIBLE);
                    }
                    booksList.setAdapter(new BooksAdapter(MainActivity.this, books));
                    MainActivity.this.bookss = books;
                    Log.d("book",bookss.toString());
                    Log.d("book1",books.toString());
                }
            });
        }



    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(MainActivity.this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);




    }
}
