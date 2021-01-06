package com.example.myapplication.network

import com.example.myapplication.data.LoginRequest
import com.example.myapplication.data.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @FormUrlEncoded
    @POST("/user/login")
    fun Login(@Field ("userid")userid: String, @Field ("userpassword")userpassword: String): Call<LoginResponse>


    @GET("/product/sell")
    fun sell(@Query ("cell")cell: String, @Query ("name")name: String, @Query ("userid")userid: String, @Query ("price")price: String): Call<Void>
}