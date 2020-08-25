package com.samkit.mycompanymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Marketing1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing1);
        Button headdetails = findViewById(R.id.headdetails);
        Button employeedetails = findViewById(R.id.employeedetails);
        Button addemployee = findViewById(R.id.addemployee);
        Button addhead = findViewById(R.id.addemp);

        headdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Marketing1.this, showmarketinghead.class);
                startActivity(i);
            }
        });
        employeedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Marketing1.this, showmarketingemp.class);
                startActivity(i);
            }
        });
        addemployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Marketing1.this, addemployee.class);
                startActivity(i);
            }
        });
        addhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Marketing1.this, addnewhead.class);
                startActivity(i);
            }
        });



    }
}
