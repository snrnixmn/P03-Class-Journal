package com.example.p03_class_journal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter<DailyCA> {

    private Context context;
    private ArrayList<DailyCA> dailyCA;
    private TextView tvWeek, tvGrade, tvdg;
    private ImageView ivPic;

    public DGAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        dailyCA = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeek = (TextView) rowView.findViewById(R.id.tvWeek);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);
        tvdg = (TextView) rowView.findViewById(R.id.tvDG);

        // Get the ImageView object
        ivPic = (ImageView) rowView.findViewById(R.id.ivPic);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyCA currentGrade = dailyCA.get(position);
        // Set the TextView to show the food

        tvWeek.setText("Week " + String.valueOf(currentGrade.getWeek()));
        tvGrade.setText(currentGrade.getDgGrade());
        tvdg.setText("DG");
        ivPic.setImageResource(R.drawable.dg);

        // Set the image accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }
}

