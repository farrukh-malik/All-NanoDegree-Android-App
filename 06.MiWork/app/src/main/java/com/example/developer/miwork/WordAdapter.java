package com.example.developer.miwork;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Developer on 8/14/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    public WordAdapter(Activity Context, ArrayList<Word> words,int ColorResourceId){
        super(Context, 0 ,words);
        mColorResourceId =ColorResourceId;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);

        }
    Word currentWord = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiworkTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            //method for hiding image
            imageView.setVisibility(View.GONE);
        }
        //set the theme color for list items
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that resource id map
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //set hte backgroundcolour for the textview
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
