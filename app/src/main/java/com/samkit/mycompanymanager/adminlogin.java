package com.samkit.mycompanymanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminlogin extends AppCompatActivity {
    EditText id;
    EditText password;
    TextView info;
    Button signin1;
    String empid;
    String emppassword;
    CheckBox rememberadmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        id = findViewById(R.id.loginid);
        password = findViewById(R.id.password);
        signin1 = findViewById(R.id.signinbtn);
        info = findViewById(R.id.info);
        empid = String.valueOf(id);
        emppassword = String.valueOf(password);
        rememberadmin = findViewById(R.id.rememberadmin);
        SharedPreferences preferences = getSharedPreferences("Checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        if(checkbox.equals("admin")){

                Intent i = new Intent(adminlogin.this, admin.class);
                startActivity(i);



        }
        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(("admin".equals("admin"))&&(("admin".equals("admin")))){
                    Intent i = new Intent(adminlogin.this, admin.class);
                    startActivity(i);
                    finish();
                }

            }
        });
        rememberadmin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("Checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","admin");
                    editor.apply();

                    Toast.makeText(adminlogin.this,"remembered",Toast.LENGTH_SHORT).show();

                }else if(!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("Checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","notadmin");
                    editor.apply();
                    Toast.makeText(adminlogin.this,"Wont remember you!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}