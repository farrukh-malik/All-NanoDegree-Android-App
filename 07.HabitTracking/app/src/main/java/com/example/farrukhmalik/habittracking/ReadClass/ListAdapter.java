package com.example.farrukhmalik.habittracking.ReadClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.farrukhmalik.habittracking.R;

import java.util.ArrayList;

/**
 * Created by Farrukh Malik on 10/27/2016.
 */
public class ListAdapter extends BaseAdapter {

    LayoutInflater inf;
    ArrayList<ReadClass> arr;
    Context con;
    RadioButton mon,tue,wed,thur,fri,sat,sun;
    TextView txt;



    public ListAdapter(Context c, ArrayList<ReadClass> arr) {
        this.inf = inf.from(c);
        this.arr = arr;
        this.con =c;
        this.arr=arr;



    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = inf.inflate(R.layout.diagram_for_list_view,viewGroup,false);
        txt = (TextView) v.findViewById(R.id.txt);
        txt.setText(arr.get(i).getText());


        mon = (RadioButton) v.findViewById(R.id.m);
        mon.setChecked(arr.get(i).getMon());


        tue = (RadioButton) v.findViewById(R.id.t);
        tue.setChecked(arr.get(i).getTue());

        wed = (RadioButton) v.findViewById(R.id.w);
        wed.setChecked(arr.get(i).getWed());

        thur = (RadioButton) v.findViewById(R.id.th);
        thur.setChecked(arr.get(i).getThur());

        fri = (RadioButton) v.findViewById(R.id.fr);
        fri.setChecked(arr.get(i).getFri());

        sat = (RadioButton) v.findViewById(R.id.satd);
        sat.setChecked(arr.get(i).getSat());

        sun = (RadioButton) v.findViewById(R.id.sund);
        sun.setChecked(arr.get(i).getSun());




        return v;
    }
}
