package com.example.p03_class_journal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<DailyCA> grades;
    ArrayAdapter aa;
    Button btnInfo, btnAdd, btnEmail;
    int requestCodeForStats = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvWeeks);
        btnInfo = (Button) this.findViewById(R.id.btnInfo);
        btnAdd = (Button) this.findViewById(R.id.btnAdd);
        btnEmail = (Button) this.findViewById(R.id.btnEmail);

        // Create a few moduke objects in given years array
        grades = new ArrayList<DailyCA>();

        // Set listener to handle the clicking of Batman TextView
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(SecondActivity.this, WeekStatsActivity.class);
                // Start the activity
                startActivityForResult(i, requestCodeForStats);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = getIntent();
                String faciEmail = i.getStringExtra("faciEmail");
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{faciEmail});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
               email.putExtra(Intent.EXTRA_TEXT,"Hi");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                String info = data.getStringExtra("rb");
                String statement = "";
                grades.add(new DailyCA(info, "C347", grades.size() + 1));
                aa = new DGAdapter(this, R.layout.row, grades);
                lv.setAdapter(aa);
            }
        }

    }

}