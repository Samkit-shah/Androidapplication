package com.samkit.mycompanymanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class marketingemployee extends AppCompatActivity {
    String empid;
    Button showtask;
    Button leaveapplication;
    TextView showempdetails;
    Button emplogout;
int emp_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketingemployee);
        emplogout = findViewById(R.id.emplogout);
        emplogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("empcheckbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","notemp");
                editor.apply();
                finish();


            }
        });


        empid = getIntent().getStringExtra("empid");

         showtask = findViewById(R.id.showtask);
         leaveapplication = findViewById(R.id.leaveapplication);
         showempdetails = findViewById(R.id.empdetails);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Headapi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();


            Api empapi = retrofit.create(Api.class);


            Call<List<getmarketingempdetails>> call = empapi.getmarketingempdetails(Integer.parseInt(empid));
            call.enqueue(new Callback<List<getmarketingempdetails>>() {
                @Override
                public void onResponse(Call<List<getmarketingempdetails>> call, Response<List<getmarketingempdetails>> response) {

                    if (!response.isSuccessful()) {
                        showempdetails.setText("Code: " + response.code());
                        return;
                    }

                    List<getmarketingempdetails> headdetails = response.body();

                    for (getmarketingempdetails marketingheaddetails : headdetails) {
                        String content = "";

                        content += "Id " + marketingheaddetails.getId() + "\n";
                        content += "Name " + marketingheaddetails.getName() + "\n";
                        content += "Contact " + marketingheaddetails.getContact() + "\n";





                        showempdetails.append(content);
                    }
                }
                @Override
                public void onFailure(Call<List<getmarketingempdetails>> call, Throwable t) {
                    Toast.makeText(marketingemployee.this, "GOOD JOB", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    showempdetails.setText(t.getMessage());
                }
            });

        showtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(marketingemployee.this, showtaskforemp.class);
                i.putExtra("empid", empid);
                startActivity(i);

            }
        });
        leaveapplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(marketingemployee.this, showtaskforemp.class);


                i.putExtra("empid", empid);

                startActivity(i);
            }
        });
        showempdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(marketingemployee.this, showempdetails.class);

                i.putExtra("empid", empid);

                startActivity(i);
            }
        });
    }
}
