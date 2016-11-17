package com.example.faiz.newsapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView booksList;
    private TextView responseText;
    static final String API_URL = "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=";
    private ArrayList<News> arrayList;
    private ImageView imageViewCover;
    private EditText searchEditText;
//    '1.0&q=barack%20obama'
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksList = (ListView) findViewById(R.id.books_list);
        responseText = (TextView) findViewById(R.id.txt_response);
        responseText.setVisibility(View.VISIBLE);

        searchEditText = (EditText) findViewById(R.id.search_edit_text);
        final Button searchButton = (Button) findViewById(R.id.btn_search);
        imageViewCover  = (ImageView)findViewById(R.id.coverimage);

        arrayList = new ArrayList<News>();
        imageViewCover.setVisibility(View.VISIBLE);


            assert searchButton != null;
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String keyword = searchEditText.getText().toString();
                    if (keyword.equals("")) {
                        responseText.setText("Please enter a News name.");
                        responseText.setVisibility(View.VISIBLE);
                        imageViewCover.setVisibility(View.VISIBLE);
                        booksList.setVisibility(View.GONE);

                    } else {
                        imageViewCover.setVisibility(View.GONE);
                        new fetchBooksList().execute(API_URL + keyword);
                    }
                }
            });

    }


    private class fetchBooksList extends AsyncTask<String, Void, String> {

        ArrayList<News> newsArrayList = new ArrayList<News>();

        @Override
        protected String doInBackground(String... params) {
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

                JSONObject json = new JSONObject(builder.toString());

                    Log.d("ss",json.toString());

                    JSONObject obj = json.getJSONObject("responseData");

                    JSONArray array = obj.getJSONArray("entries");
                    String[] authors = new String[array.length()];

                    Log.d("aa",array.toString());

                    for(int i=0;i<array.length();i++){
                        JSONObject bookItem = array.getJSONObject(i);
                       Log.d("aaa",bookItem.toString());

                        String url1 = bookItem.getString("url");
                        Log.d("sss",url1);
                        //   String title = String.valueOf(bookItem.get("title"));
                        String title = bookItem.getString("title");
                        Log.d("af",title);




                        String link = bookItem.getString("link");
                        Log.d("ad",link);

                     String   str = title.replaceAll("\\<(.*)?\\>(.*)\\</\\1\\>", "$2");

                        Log.d("str",str);

                        newsArrayList.add(new News(str,link));
                        arrayList.add(new News(str,link));
                        SharedRef.setCurrentUser(MainActivity.this,new News(str,link));
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
                    if (newsArrayList.size() == 0) {
                        responseText.setVisibility(View.VISIBLE);
                    } else {
                        responseText.setVisibility(View.GONE);
                        booksList.setVisibility(View.VISIBLE);
                    }

                    booksList.setAdapter(new Adapters(MainActivity.this, newsArrayList));

                       MainActivity.this.arrayList = newsArrayList;
//                    booksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            Uri uri = Uri.parse(newsArrayList.get(position).getTitle()      );
//                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                            startActivity(intent);
//
//                        }
//                    });
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
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("key", arrayList);
        Log.d("tag",outState.getParcelableArrayList("key").toString());
    Toast.makeText(MainActivity.this,"SaveInstanceMethod",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {



        super.onRestoreInstanceState(savedInstanceState);
        Log.d("key",savedInstanceState.getParcelableArrayList("key").toString());

        arrayList = savedInstanceState.getParcelableArrayList("key");
        booksList.setAdapter(new Adapters(MainActivity.this,arrayList));
        Toast.makeText(MainActivity.this,"RestoreInstanceMethod",Toast.LENGTH_LONG).show();
    }

}
