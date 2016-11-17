package com.example.developer.miwork;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
    releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        //for audio focus
        mAudioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //create an array
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("01" ,"One",R.drawable.number_one,R.raw.one));
        words.add(new Word("02","TWo",R.drawable.number_two,R.raw.two));
        words.add(new Word("03","Three",R.drawable.number_three,R.raw.three));
        words.add(new Word("04","Four",R.drawable.number_four,R.raw.four));
        words.add(new Word("05","Five",R.drawable.number_five,R.raw.five));
        words.add(new Word("06","Six",R.drawable.number_six,R.raw.six));
        words.add(new Word("07","Seven",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("08","Eight",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("09","Nine",R.drawable.number_nine,R.raw.nine));
       words.add(new Word("10","Ten",R.drawable.number_ten,R.raw.ten));

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                releaseMediaPlayer();
                //setting id for audio
                mMediaPlayer=MediaPlayer.create(Numbers.this,word.getmAudioResourceId());
                //playing
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }
        });


    }
    //for stoping media files when app stops
    protected void oStop(){
        super.onStop();
        releaseMediaPlayer();

    }

    public void releaseMediaPlayer(){
        if (mMediaPlayer != null){

            mMediaPlayer.release();
            mMediaPlayer = null;
        }

    }
}


        //find the roor vie of layout
       // LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
// for printing throw while loop
// int index = 0;
//
//        while (index < 10) {
//            //creating text view that display the word
//            //and add thaat view as a child to rootview
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//            //updating the variable
//            index++;
//        }
//for ptinting a single value on screen
//        LinearLayout rootView =(LinearLayout) findViewById(R.id.rootView);
//        TextView wordView = new TextView(this);
//        wordView.setText(words.get(0));
//        rootView.addView(wordView);


