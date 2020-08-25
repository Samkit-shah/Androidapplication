package com.samkit.mycompanymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class loginas extends AppCompatActivity {
    Button emplogin;
    Button headlogin;
    Button adminlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginas);
        emplogin = findViewById(R.id.emplogin);




         emplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginas.this, emplogin.class);
                startActivity(i);
                finish();
            }
        });
        headlogin = findViewById(R.id.headlogin);
        headlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginas.this, login.class);
                startActivity(i);
                finish();
            }
        });
        adminlogin = findViewById(R.id.adminlogin);
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginas.this, adminlogin.class);
                startActivity(i);
                finish();
            }
        });


    }
}
