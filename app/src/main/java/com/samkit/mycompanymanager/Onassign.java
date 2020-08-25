package com.samkit.mycompanymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Onassign extends AppCompatActivity {
    String empidtask;
    String headid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onassign);
        empidtask = getIntent().getExtras().getString("empidtask");
        getHeads();
    }

    private void getHeads() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<getmarketingempdetails>> call = api.getmarketingempdetails();
        call.enqueue(new Callback<List<getmarketingempdetails>>() {
            @Override
            public void onResponse(Call<List<getmarketingempdetails>> call, Response<List<getmarketingempdetails>> response) {


                List<getmarketingempdetails> detailsList = response.body();

                String[] heads = new String[detailsList.size()];
                for (int i = 0; i < detailsList.size(); i++) {
                    heads[i] = detailsList.get(i).getId().toString();


                }


                for (int i = 0; i < detailsList.size(); i++) {
                    if (heads[i].equals(empidtask)) {
                        Intent intent = new Intent(Onassign.this, tasktomarketing.class);
                        intent.putExtra("empidtask",empidtask);
                        headid = getIntent().getStringExtra("headid");
                        intent.putExtra("headid", headid);
                        startActivity(intent);
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
