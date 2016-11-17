package com.example.faiz.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Faiz on 8/2/2016.
 */
public class Adapters extends ArrayAdapter<News> {
    public Adapters(Context context,ArrayList<News> resource) {
        super(context,0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News book = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.txt_title);
        TextView authorsTextView = (TextView) listItemView.findViewById(R.id.txt_authors);

        titleTextView.setText(book.getTitle());
        authorsTextView.setText(book.getNews());

        return listItemView;

    }
}
