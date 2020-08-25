package com.samkit.mycompanymanager;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Taskapi {  String BASE_URL = "http://192.168.0.106/sns/public/api/";

    @POST("marketingtask")
    Call<Taskassign> createtask(@Body Taskassign task    );

    /*@FormUrlEncoded
    @POST("marketingtask")
    Call<Taskassign> createtask(
            @Field("head_id") int headId,
            @Field("emp_id") int employeeId,
            @Field("task_details") String taskDetails
    );*/
    @GET("marketingtask/{emp_id}")
    Call<List<Taskdetails>> showtask(@Path("emp_id") Integer employeeId);
    @GET("marketingtask")
    Call<List<Taskdetails>> showtask1();

}
