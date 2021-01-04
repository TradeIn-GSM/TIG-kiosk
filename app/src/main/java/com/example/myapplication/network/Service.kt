package com.example.myapplication.network

import com.example.myapplication.data.LoginRequest
import com.example.myapplication.data.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Service {
    @FormUrlEncoded
    @POST("/user/login")
    fun Login(@Field ("userid")userid: String, @Field ("userpassword")userpassword: String): Call<LoginResponse>
}