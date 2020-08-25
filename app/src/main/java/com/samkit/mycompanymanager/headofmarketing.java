package com.samkit.mycompanymanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class headofmarketing extends AppCompatActivity {
    String headid;
    Button headlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headofmarketing);
        Button showemployees = findViewById(R.id.showemployees);
        Button assigntask = findViewById(R.id.assigntask);
        headid = getIntent().getStringExtra("headid");
        Log.d("id of head",headid);
        headlogout = findViewById(R.id.headlogout);
        headlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("headcheckbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","nothead");
                editor.apply();
                finish();


            }
        });

        showemployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(headofmarketing.this, showmarketingemp.class);
                startActivity(i);
            }
        });
        assigntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(headofmarketing.this, assigntaskmarketing.class);

                i.putExtra("headid", headid);

                startActivity(i);
            }
        });

    }
}
