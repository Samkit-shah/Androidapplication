package com.samkit.mycompanymanager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Headapi {

    String BASE_URL = "http://192.168.0.106/sns/public/api/";
    @POST("marketinghead")
    Call<addmarketinghead> addnewhead(@Body addmarketinghead addemp);
    @GET("marketinghead")
    Call<List<getmarketingheaddetails>> getmarketingheaddetails();
    @GET("marketinghead/{id}")
    Call<List<getmarketingheaddetails>> getmarketingheaddetails(@Path("id") int  marketinghead_id);

}
