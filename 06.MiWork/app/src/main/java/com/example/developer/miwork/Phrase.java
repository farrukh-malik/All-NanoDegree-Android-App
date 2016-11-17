package com.example.developer.miwork;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Phrase extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrase);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Kese ho?" ,"How are you?",R.raw.hru));
        words.add(new Word("Kahan ho?","Where Are You?",R.raw.wru));
        words.add(new Word("Kya ho raha h?","What's up?",R.raw.wup));
        words.add(new Word("Kya tum Farigh ho?","Are u free?",R.raw.ruf));
        words.add(new Word("Me theek hon","I am fine",R.raw.imf));
        words.add(new Word("Jld a raha h","coming soon ",R.raw.coms));
        words.add(new Word("Acha","goood",R.raw.good));
        words.add(new Word("Allah Hafiz","good bye",R.raw.by));
        words.add(new Word("Suno","listen?",R.raw.l));
        words.add(new Word("Pocho","ask ?",R.raw.ask));
        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_phrase);
        GridView listview =(GridView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);
                mMediaPlayer= MediaPlayer.create(Phrase.this,word.getmAudioResourceId());
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
