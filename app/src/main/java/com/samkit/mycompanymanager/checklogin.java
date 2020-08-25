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

public class checklogin extends AppCompatActivity {
    public String headid;
    public String headpassword;
    public String id;
    public String password;
    TextView wrongdetials;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklogin);
        wrongdetials = findViewById(R.id.wrongdetials);
        headid = getIntent().getStringExtra("headid");
        headpassword = getIntent().getStringExtra("headpassword");

            checkloginpass();




    }

    private void checkloginpass() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Headapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        Headapi headloginapi = retrofit.create(Headapi.class);




        Call<List<getmarketingheaddetails>> call = headloginapi.getmarketingheaddetails(Integer.parseInt(headid));
        call.enqueue(new Callback<List<getmarketingheaddetails>>() {
            @Override
            public void onResponse(Call<List<getmarketingheaddetails>> call, Response<List<getmarketingheaddetails>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }


                List<getmarketingheaddetails> marketingheadlogin = response.body();

                for (getmarketingheaddetails marketingheadlogind : marketingheadlogin) {
                    String content = "";
                    password = marketingheadlogind.getPassword();
                    Log.d("password", password);
                    id = String.valueOf(marketingheadlogind.getId());
                    Log.d("id", id);

                    if (password.equals(headpassword)) {
                        Intent i = new Intent(checklogin.this, headofmarketing.class);
                        i.putExtra("headid", headid);
                        startActivity(i);
                        Log.d("yes or no","yes");
                        finish();
                    }
                    else  {

                        Toast.makeText(checklogin.this, "ENTER CORRECT DETAILS", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                }



            }



            @Override
            public void onFailure(Call<List<getmarketingheaddetails>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


}
    }




