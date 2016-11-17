package com.example.developer.miwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Dada","Grand Father",R.drawable.family_grandfather,R.raw.grndfather));
        words.add(new Word("Dadi","Grand Mother",R.drawable.family_grandmother,R.raw.grndmother));
        words.add(new Word("Papa" ,"Father",R.drawable.family_father,R.raw.father));
        words.add(new Word("Mammi","Mother",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("Bare Bhai","Older Brother",R.drawable.family_older_brother,R.raw.olderbro));
        words.add(new Word("Chote Bhai","Younger Brother",R.drawable.family_younger_brother,R.raw.yngrbro));
        words.add(new Word("Bari Bhen","Oldar Sister",R.drawable.family_older_sister,R.raw.olddrsis));
        words.add(new Word("Choti Bhen","YoungerSister",R.drawable.family_younger_sister,R.raw.yngrsis));
        words.add(new Word("Beti","Daughter",R.drawable.family_daughter,R.raw.doughtr));
        words.add(new Word("Beta","Son",R.drawable.family_son,R.raw.son));
        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_family);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(Family.this,word.getmAudioResourceId());
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
