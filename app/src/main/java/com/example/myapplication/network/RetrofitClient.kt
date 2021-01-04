package com.example.myapplication.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://6af3b41787a3.ngrok.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getUserAPI() : Service{
        return retrofit.create(Service::class.java)
    }
}