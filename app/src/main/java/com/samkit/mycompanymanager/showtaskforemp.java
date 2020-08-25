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

public class showtaskforemp extends AppCompatActivity {
    ListView listView;
    private Taskapi taskapi;
    String empid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtaskforemp);
        listView = (ListView) findViewById(R.id.showmarketingemp);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Taskapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        taskapi= retrofit.create(Taskapi.class);
        showemployeetasks();
    }

    private void showemployeetasks() {

        empid = getIntent().getStringExtra("empid");

        Call<List<Taskdetails>> call = taskapi.showtask(Integer.valueOf(empid));

        call.enqueue(new Callback<List<Taskdetails>>() {
            @Override
            public void onResponse(Call<List<Taskdetails>> call, Response<List<Taskdetails>> response) {


                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    return;
                }


                List<Taskdetails> emptaskdetails = response.body();
                String[] employeetask = new String[emptaskdetails.size()];
                String[] employeetasktime = new String[emptaskdetails.size()];
                for (int i = 0; i < emptaskdetails.size(); i++) {
                    employeetask[i]= emptaskdetails.get(i).getTaskDetails();

                }
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, employeetask));
            }


            @Override
            public void onFailure(Call<List<Taskdetails>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
