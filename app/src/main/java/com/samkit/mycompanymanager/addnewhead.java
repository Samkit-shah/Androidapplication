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

public class addnewhead extends AppCompatActivity {
    EditText empid;
    EditText empname;
    EditText empcontact;
    EditText empqualification;
    EditText emppassword;
    EditText empaddress;
    EditText empsalary;
    Button addhead;

    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewhead);
        empid = findViewById(R.id.empid);
        empname = findViewById(R.id.empname);
        empcontact = findViewById(R.id.empcontact);
        empqualification = findViewById(R.id.empqualification);
        emppassword = findViewById(R.id.emppassword);
        empaddress = findViewById(R.id.empaddress);
        empsalary = findViewById(R.id.empsalary);
        addhead = findViewById(R.id.addhead);



        addhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_emp();
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            Headapi headapi = retrofit.create(Headapi.class);

            private void add_emp(){
                String name = empname.getText().toString();
                String address = empaddress.getText().toString();
                String qualification = empqualification.getText().toString();
                String password = emppassword.getText().toString();
                String salary = empsalary.getText().toString();
                int id = Integer.parseInt(empid.getText().toString());
                int contact = Integer.parseInt(empcontact.getText().toString());

                addmarketinghead addhead1 = new addmarketinghead(id,name,contact,address,qualification,password,salary);
                Call<addmarketinghead> call  = headapi.addnewhead(addhead1);
                call.enqueue(new Callback<addmarketinghead>() {
                    @Override
                    public void onResponse(Call<addmarketinghead> call, Response<addmarketinghead> response) {

                        if(response.isSuccessful()) {

                            Log.d("response", "post submitted to API." + response.body().toString());
                        }


                        Toast.makeText(addnewhead.this, "HEAD ADDED" , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<addmarketinghead> call, Throwable t) {
                        error.setText(t.getMessage());

                    }
                });


            }
        });

    }





}
