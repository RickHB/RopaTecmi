package com.example.ropatecmi.network;

import com.example.ropatecmi.model.LoginRequest;
import com.example.ropatecmi.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);
}
