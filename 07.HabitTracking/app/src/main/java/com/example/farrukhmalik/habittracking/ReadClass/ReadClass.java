package com.example.farrukhmalik.habittracking.ReadClass;

/**
 * Created by Farrukh Malik on 10/27/2016.
 */
public class ReadClass {
    String text;
    Boolean mon,tue,wed,thur,fri,sat,sun;
    Boolean[] barr = new Boolean[7];
    public ReadClass(String text, int[] arr) {
        this.text = text;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                barr[i]=true;

            }
            else {
                barr[i]=false;

            }
        }


    }


    public String getText() {
        return text;
    }

    public Boolean getMon() {


        return barr[0];
    }

    public Boolean getTue() {
        return barr[1];
    }

    public Boolean getWed() {
        return barr[2];
    }

    public Boolean getThur() {
        return barr[3];
    }

    public Boolean getFri() {
        return barr[4];
    }

    public Boolean getSat() {
        return barr[5];
    }

    public Boolean getSun() {
        return barr[6];
    }
}
