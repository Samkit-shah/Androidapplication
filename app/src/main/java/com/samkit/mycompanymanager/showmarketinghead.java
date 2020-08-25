package com.samkit.mycompanymanager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class showmarketinghead extends AppCompatActivity {
    ListView listView;
    private  String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmarketinghead);
        listView = (ListView) findViewById(R.id.showmarketingemp);
        getmarketinghead();
    }

    private void getmarketinghead() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Headapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        Headapi headapi = retrofit.create(Headapi.class);


        Call<List<getmarketingheaddetails>> call = headapi.getmarketingheaddetails();
        call.enqueue(new Callback<List<getmarketingheaddetails>>() {
            @Override
            public void onResponse(Call<List<getmarketingheaddetails>> call, Response<List<getmarketingheaddetails>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<getmarketingheaddetails> headdetails = response.body();
                String[] marketingheadnames = new String[headdetails.size()];

                //looping through all the marketingheadnames and inserting the names inside the string array
                for (int i = 0; i < headdetails.size(); i++) {
                    marketingheadnames[i]= headdetails.get(i).getName();


                }listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, marketingheadnames));

            }
            @Override
            public void onFailure(Call<List<getmarketingheaddetails>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });



    }
}
