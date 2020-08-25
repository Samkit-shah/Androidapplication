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

public class showmarketingemp extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmarketingemp);
        listView = (ListView) findViewById(R.id.showmarketingemp);

        //calling the method to display the heroes
        getmarketingemp();
    }

    private void getmarketingemp() {
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

                //Creating an String array for the ListView
                String[] marketingempnames = new String[detailsList.size()];

                //looping through all the marketingempnames and inserting the names inside the string array
                for (int i = 0; i < detailsList.size(); i++) {
                    marketingempnames[i]= detailsList.get(i).getName();


                }


                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, marketingempnames));

            }

            @Override
            public void onFailure(Call<List<getmarketingempdetails>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }


}
