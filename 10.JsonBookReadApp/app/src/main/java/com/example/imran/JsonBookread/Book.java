package com.example.faiz.bookread;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;


public class Book {

    private String mTitle;
    private String[] mAuthors;
    private String imageURL;

    public Book() {
    }

    public Book(String mTitle, String[] mAuthors, String imageURL) {
        this.mTitle = mTitle;
        this.mAuthors = mAuthors;
        this.imageURL = imageURL;
    }


    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmAuthors(String[] mAuthors) {
        this.mAuthors = mAuthors;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthors() {
        return TextUtils.join(", ", mAuthors);
    }

}
