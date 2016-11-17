package com.example.faiz.bookread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BooksAdapter extends ArrayAdapter<Book> {

    private Picasso picasso;

    public BooksAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.book_list_item, parent, false);
        }

        Book book = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.txt_title);
        TextView authorsTextView = (TextView) listItemView.findViewById(R.id.txt_authors);
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.bookImage);

        picasso.with(getContext()).load(book.getImageURL()).into(imageView);


        titleTextView.setText(book.getTitle());
        authorsTextView.setText(book.getAuthors());

        return listItemView;
    }
}
