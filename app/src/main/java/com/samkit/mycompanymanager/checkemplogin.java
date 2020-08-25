package com.samkit.mycompanymanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class checkemplogin extends AppCompatActivity {
    public String empid;
    public String emppassword;
    public String id;
    public String password;
    TextView wrongdetials;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkemplogin);
        wrongdetials = findViewById(R.id.wrongdetials);
        empid = getIntent().getStringExtra("empid1");
        emppassword = getIntent().getStringExtra("emppassword1");
        Log.d("empid",empid);
        checkemploginpass();
    }



    private void checkemploginpass() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Headapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api emploginapi = retrofit.create(Api.class);




        Call<List<getmarketingempdetails>> call = emploginapi.getmarketingempdetails(Integer.parseInt(empid));
        call.enqueue(new Callback<List<getmarketingempdetails>>() {
            @Override
            public void onResponse(Call<List<getmarketingempdetails>> call, Response<List<getmarketingempdetails>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<getmarketingempdetails> marketingemplogin = response.body();

                for (getmarketingempdetails marketingemplogind : marketingemplogin) {

                    String content = "";
                    password = marketingemplogind.getPassword();
                    Log.d("password", password);
                    id = String.valueOf(marketingemplogind.getId());
                    Log.d("id", id);


                    if (password.equals(emppassword)) {
                        Intent i = new Intent(checkemplogin.this, marketingemployee.class);
                        i.putExtra("empid", empid);
                        startActivity(i);
                        Log.d("yes or no","yes");
                        finish();
                    }
                    else{
                        Toast.makeText(checkemplogin.this, "ENTER CORRECT DETAILS", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }



            @Override
            public void onFailure(Call<List<getmarketingempdetails>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
}





