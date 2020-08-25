package com.samkit.mycompanymanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class admin extends AppCompatActivity {
    ListView listv;
    Button adminlogout;
    String [] listvitems = new String[]{
            "MARKETING","FINANCE","IT","HR"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        listv= findViewById(R.id.listv);
         adminlogout = findViewById(R.id.adminlogout);
        adminlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("Checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","notadmin");
                editor.apply();
                finish();


            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_2,android.R.id.text2,listvitems);



        listv.setAdapter(adapter);

        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dep = listvitems[position];
                if(dep.equals("IT"))
                {
                    Intent i = new Intent(admin.this,Marketing1.class);
                    startActivity(i);
                }
                else if(dep.equals("HR"))
                {
                    Intent i = new Intent(admin.this,Marketing1.class);
                    startActivity(i);
                }
                else if(dep.equals("MARKETING"))
                {
                    Intent i = new Intent(admin.this,Marketing1.class);
                    startActivity(i);
                }
                else if(dep.equals("FINANCE"))
                {
                    Intent i = new Intent(admin.this,Marketing1.class);
                    startActivity(i);
                }




            }
        });









    }
}
