package com.example.myapplication.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    private var retrofit = Retrofit.Builder()
        .baseUrl("http://10.120.73.74:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getUserAPI() : Service{
        return retrofit.create(Service::class.java)
    }
    fun sellProduct() : Service{
        return retrofit.create(Service::class.java)
    }
    fun buyProduct() : Service{
        return retrofit.create(Service::class.java)
    }
    fun moneyAPI() : Service{
        return retrofit.create(Service::class.java)
    }
}