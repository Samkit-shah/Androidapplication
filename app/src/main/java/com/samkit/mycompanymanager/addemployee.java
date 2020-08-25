package com.samkit.mycompanymanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class addemployee extends AppCompatActivity {
    EditText empid;
    EditText empname;
    EditText empcontact;
    EditText empqualification;
    EditText emppassword;
    EditText empaddress;
    EditText empsalary;
    Button addemp;

    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);
        empid = findViewById(R.id.empid);
        empname = findViewById(R.id.empname);
        empcontact = findViewById(R.id.empcontact);
        empqualification = findViewById(R.id.empqualification);
        emppassword = findViewById(R.id.emppassword);
        empaddress = findViewById(R.id.empaddress);
        empsalary = findViewById(R.id.empsalary);
        addemp = findViewById(R.id.addemp);
        error = findViewById(R.id.error);




        addemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_emp();
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            Api addapi = retrofit.create(Api.class);

            private void add_emp(){
                String name = empname.getText().toString();
                String address = empaddress.getText().toString();
                String qualification = empqualification.getText().toString();
                String password = emppassword.getText().toString();
                String salary = empsalary.getText().toString();
                int id = Integer.parseInt(empid.getText().toString());
                int contact = Integer.parseInt(empcontact.getText().toString());

                addmarketingemp addemp1 = new addmarketingemp(id,name,contact,address,qualification,password,salary);
                Call<addmarketingemp> call  = addapi.addnewemp(addemp1);
                call.enqueue(new Callback<addmarketingemp>() {
                    @Override
                    public void onResponse(Call<addmarketingemp> call, Response<addmarketingemp> response) {

                        if(response.isSuccessful()) {

                            Log.d("response", "post submitted to API." + response.body().toString());
                        }


                        Toast.makeText(addemployee.this, "EMPLOYEE ADDED" , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<addmarketingemp> call, Throwable t) {
                        error.setText(t.getMessage());

                    }
                });


            }
        });

    }





}


