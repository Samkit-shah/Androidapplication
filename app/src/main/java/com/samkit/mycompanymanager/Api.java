package com.samkit.mycompanymanager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {


    String BASE_URL = "http://192.168.0.106/sns/public/api/";
    @POST("marketingemp")
    Call<addmarketingemp> addnewemp(@Body addmarketingemp addemp);
    @GET("marketingemp")
    Call<List<getmarketingempdetails>> getmarketingempdetails();
    @GET("marketingemp/{id}")
    Call<List<getmarketingempdetails>> getmarketingempdetails(@Path("id") int  marketinghead_id);


}
