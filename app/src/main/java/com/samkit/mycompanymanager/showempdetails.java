package com.samkit.mycompanymanager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class showempdetails extends AppCompatActivity {
    String empid;
    TextView show_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showempdetails);
        show_details = findViewById(R.id.show_details);
         empid = getIntent().getStringExtra("empid");
        showemployeedetails();
    }
    private void showemployeedetails() {
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

                List<getmarketingempdetails> marketingempdetails = response.body();

                for (getmarketingempdetails marketingemplogind : marketingempdetails) {

                    String content = "";

                    content += "\t";
                    content += "Id " + marketingemplogind.getId() + "\n";
                    content += "Name " + marketingemplogind.getName() + "\n";
                    content += "Contact " + marketingemplogind.getContact() + "\n";
                    content += "Qualification " + marketingemplogind.getQualification() + "\n\n\n\n\n";




                    show_details.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<getmarketingempdetails>> call, Throwable t) {
                Toast.makeText(showempdetails.this, "GOOD JOB", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
