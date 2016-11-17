package com.example.developer.miwork;

/**
 * Created by Developer on 8/14/2016.
 */
public class Word {
    //default translation of word
    private String mDefaultTranslation;
    //mi work translation for work
    private String mMiworkTranslation;
    //for audio
    private int mAudioResourceId;
    //for image id
    private int mImageResourceId= NO_IMAGE_PROVIDED;
    public static final int NO_IMAGE_PROVIDED = -1;


    public Word(String defaulttranslation,String mworkTranslation,int audioResourceId){
        mDefaultTranslation = defaulttranslation;
        mMiworkTranslation = mworkTranslation;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaulttranslation,String mworkTranslation,int imageResourceId,int audioResourceId){
        mDefaultTranslation = defaulttranslation;
        mMiworkTranslation = mworkTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId =audioResourceId;
    }
    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }
    public String getMiworkTranslation(){
        return mMiworkTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public int getmAudioResourceId(){
        return mAudioResourceId;
    }
}
