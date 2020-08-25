package com.samkit.mycompanymanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class emplogin extends AppCompatActivity {
    EditText id;
    EditText password;
    TextView info;
    Button signin1;

    CheckBox rememberemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplogin);
        id = findViewById(R.id.loginid);
        password = findViewById(R.id.password);
        signin1 = findViewById(R.id.signinbtn);
        info = findViewById(R.id.info);


        rememberemp = findViewById(R.id.rememberemp);

        SharedPreferences preferences = getSharedPreferences("empcheckbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        SharedPreferences preferences2 = getSharedPreferences("empdetails",MODE_PRIVATE);
        final String empid = preferences2.getString("empid","");
        Log.d("id of emp",empid);
        if(checkbox.equals("emp")){
            Intent i = new Intent(emplogin.this, marketingemployee.class);
            i.putExtra("empid", empid);
            startActivity(i);
            finish();



        }
        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(emplogin.this, checkemplogin.class);
                Log.d("id of emp",id.getText().toString());
                i.putExtra("empid1", id.getText().toString());
                i.putExtra("emppassword1",password.getText().toString());
                startActivity(i);
                finish();

            }
        });
        rememberemp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("empcheckbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","emp");
                    editor.apply();
                    SharedPreferences preferences2 = getSharedPreferences("empdetails",MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.putString("empid",id.getText().toString());
                    editor2.putString("emppassword",password.getText().toString());
                    editor2.apply();
                    Toast.makeText(emplogin.this,"remembered",Toast.LENGTH_SHORT).show();

                }else if(!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("empcheckbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","notemp");
                    editor.apply();
                    Toast.makeText(emplogin.this,"Wont remember you!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
