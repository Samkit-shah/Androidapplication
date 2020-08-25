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

public class login extends AppCompatActivity {
     EditText id;
     EditText password;
     TextView info;
    Button signin1;
    String empid;
    String emppassword;
    CheckBox rememberhead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id = findViewById(R.id.loginid);
        password = findViewById(R.id.password);
        signin1 = findViewById(R.id.signinbtn);
        info = findViewById(R.id.info);
        empid = id.getText().toString();
        emppassword = password.getText().toString();
        rememberhead = findViewById(R.id.rememberhead);
        SharedPreferences preferences = getSharedPreferences("headcheckbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        SharedPreferences preferences1 = getSharedPreferences("admindetails",MODE_PRIVATE);
        final String headid = preferences1.getString("headid","");
        Log.d("id of head",headid);
        if(checkbox.equals("head")){

            Intent i = new Intent(login.this, headofmarketing.class);
            i.putExtra("headid", headid);
            startActivity(i);
            finish();

        }else if (checkbox.equals("nothead")){
            Toast.makeText(login.this,"LOGIN IN ",Toast.LENGTH_SHORT).show();
        }

        signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(login.this, checklogin.class);
                Log.d("empid",empid);
                i.putExtra("headid", id.getText().toString());
                i.putExtra("headpassword",password.getText().toString());
                startActivity(i);
                finish();
            }
        });
        rememberhead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("headcheckbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","head");
                    editor.apply();
                    SharedPreferences preferences1 = getSharedPreferences("admindetails",MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = preferences1.edit();
                    editor1.putString("headid",id.getText().toString());
                    editor1.putString("headpassword",password.getText().toString());
                    editor1.apply();
                    Toast.makeText(login.this,"remembered",Toast.LENGTH_SHORT).show();

                }else if(!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("headcheckbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","nothead");
                    editor.apply();
                    Toast.makeText(login.this,"Wont remember you!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}

    /*private void validate(String userid,String userpassword){
        if((userid.equals("100")) && (userpassword.equals("100")))
        {
            Intent i = new Intent(login.this,admin.class);
            startActivity(i);
        }
        else if ((userid.equals("200")) && (userpassword.equals("200")))
        {
            Intent i = new Intent(login.this,headofmarketing.class);
            startActivity(i);
        }
        else if ((userid.equals("300")) && (userpassword.equals("300")))
        {
            Intent i = new Intent(login.this,admin.class);
            startActivity(i);
        }
        else
        {
            counter--;

            info.setText("No. of attempts left : " + String.valueOf(counter));
            if (counter == 1)
            {
                info.setText("Last Chance");
            }
            if (counter == 0)
            {
                signin1.setEnabled(false);
                info.setText("BYE");
                String t = "SORRY,PLEASE LEAVE";
                Toast.makeText(this,t,Toast.LENGTH_SHORT).show();
            }

        }
    }
}*/
