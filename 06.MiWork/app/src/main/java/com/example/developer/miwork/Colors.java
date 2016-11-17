package com.example.developer.miwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    private MediaPlayer mMediaPlayer ;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Lal" ,"Red",R.drawable.color_red,R.raw.red));
        words.add(new Word("Peela","Yellow",R.drawable.color_dusty_yellow,R.raw.yellow));
        words.add(new Word("Sabz","Green",R.drawable.color_green,R.raw.green));
        words.add(new Word("Broon","Brown",R.drawable.color_brown,R.raw.brown));
        words.add(new Word("Mustrd Yellow","Mustard Yellow",R.drawable.color_mustard_yellow,R.raw.mustardyellow));
        words.add(new Word("Surmai","Gray",R.drawable.color_gray,R.raw.gray));
        words.add(new Word("Safeed","White",R.drawable.color_white,R.raw.white));
        words.add(new Word("Kalaa","Black",R.drawable.color_black,R.raw.black));

        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_colors);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(Colors.this,word.getmAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);


            }
        });
        
    }
    //for stoping media files when app stops
    public void oStop(){
        super.onStop();
        releaseMediaPlayer();

    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
