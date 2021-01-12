package com.example.myapplication.network

import com.example.myapplication.data.BuyResponse
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.data.pointResponse
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @FormUrlEncoded
    @POST("/user/login")
    fun Login(@Field ("userid")userid: String, @Field ("userpassword")userpassword: String): Call<LoginResponse>


    @GET("/product/sell")
    fun sell(@Query ("cell")cell: String, @Query ("name")name: String, @Query ("userid")userid: String, @Query ("price")price: String): Call<Void>

    @FormUrlEncoded
    @POST("/product/buy")
    fun buy(@Field ("cell")cell: String, @Field ("userid")userid: String): Call<BuyResponse>

    @FormUrlEncoded
    @POST("/point/insert")
    fun insertMoney(@Field ("money")money: String): Call<Void>

    @FormUrlEncoded
    @POST("/point/charge")
    fun charge(@Field ("userid") userid: String): Call<Void>

    @FormUrlEncoded
    @POST("/user/join")
    fun join(@Field ("userid")userid: String, @Field ("username")username: String, @Field ("userpassword")userpassword: String): Call<Void>

    @GET("/point/get")
    fun point(): Call<pointResponse>
}