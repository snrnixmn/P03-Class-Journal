package com.example.p03_class_journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;
    TextView tvC347;
    int requestCodeForModuleStats = 0;

    int requestCodeForWeek1Stats = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvC347 = (TextView) findViewById(R.id.tvC347);

        tvC347.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                i.putExtra("faciEmail", "jason_lim@rp.edu.sg");
                // Start the activity
                startActivityForResult(i, requestCodeForModuleStats);
                startActivity(i);

            }

        });

    }
}