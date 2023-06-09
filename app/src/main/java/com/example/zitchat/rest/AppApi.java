package com.example.zitchat.rest;

import retrofit2.Call;

import com.example.zitchat.domain.Login;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppApi {
    @GET("hello/v1")
    Call<Login> getLogin(@Query("name") String name,@Query("password") String password);
    @GET("registration/v1")
    Call<Login> getReg(@Query("login") String login, @Query("password") String password, @Query("img") String img, @Query("st1") String st1, @Query("st2") String st2);
}
