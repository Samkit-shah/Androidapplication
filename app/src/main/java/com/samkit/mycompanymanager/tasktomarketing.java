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

public class tasktomarketing extends AppCompatActivity {
     String headid;
    String empidtask;
    TextView tasktoemp;
    EditText taskdetails;
    TextView tasktomarketing;
    Button assignbutton;
    int empidtask1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasktomarketing);
        tasktoemp = findViewById(R.id.tasktoemp);
        taskdetails = findViewById(R.id.taskdetails);
        tasktomarketing= findViewById(R.id.tasktomarketing);
        assignbutton = findViewById(R.id.assignbutton);
        empidtask = getIntent().getExtras().getString("empidtask");
        tasktoemp.setText("Assign task to: " + empidtask);



        assignbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createtask();
            }

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                        .build();

                Taskapi taskapi = retrofit.create(Taskapi.class);

            private void createtask(){
                empidtask1= Integer.parseInt(empidtask);
                final String taskdetails1 = taskdetails.getText().toString();
                headid = getIntent().getStringExtra("headid");
                final int headid1 = Integer.parseInt(headid);



                Taskassign Task = new Taskassign(headid1,empidtask1,taskdetails1);
                Call<Taskassign> call  = taskapi.createtask(Task);
                call.enqueue(new Callback<Taskassign>() {
                    @Override
                    public void onResponse(Call<Taskassign> call, Response<Taskassign> response) {

                        if(response.isSuccessful()) {

                            Log.d("response", "post submitted to API." + response.body().toString());
                        }


                        Toast.makeText(tasktomarketing.this, "TASK ASSIGNED :" + taskdetails1, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Taskassign> call, Throwable t) {
                        tasktomarketing.setText(t.getMessage());

                    }
                });


            }
        });

    }





}
