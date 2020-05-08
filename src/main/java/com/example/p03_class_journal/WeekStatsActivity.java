package com.example.p03_class_journal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WeekStatsActivity extends AppCompatActivity {

    Button btnSubmit;
    ImageView ivImage;
    RadioGroup rgGrades;
    ArrayList<String> grades;
    int requestCodeForStats = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_stats);

        btnSubmit = (Button) this.findViewById(R.id.btnSubmit);
        ivImage = (ImageView) this.findViewById(R.id.ivPic);

        ivImage.setImageResource(R.drawable.dg);

        // Get the intent
        Intent i = getIntent();
        // Get the Hero object first activity put in Intent
        DailyCA week = (DailyCA) i.getSerializableExtra("week");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                // Get RadioGroup object
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgGrades);
                // get id of selected radio button in radiogroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // get radio button object from id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);

                // Create intent & pass in String data
                Intent i = new Intent();

                // put into array
                i.putExtra("rb", rb.getText().toString());
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // like
                setResult(RESULT_OK, i);
                finish();

            }
        });
    }
}
