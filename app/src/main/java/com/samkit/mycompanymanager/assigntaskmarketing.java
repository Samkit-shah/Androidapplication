package com.samkit.mycompanymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class assigntaskmarketing extends AppCompatActivity {
    String headid;
    Button assignmarketing;
    EditText empmarketingid;
    String empidtask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigntaskmarketing);
         assignmarketing = findViewById(R.id.assignmarketing);
          empmarketingid = findViewById(R.id.empmarketingid);

        assignmarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(assigntaskmarketing.this, Onassign.class);
                headid = getIntent().getStringExtra("headid");
                i.putExtra("headid", headid);
                empidtask = empmarketingid.getText().toString();
                i.putExtra("empidtask",empidtask);
                startActivity(i);
                finish();
            }
        });

    }

}
