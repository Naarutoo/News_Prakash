package com.example.news_prakash.model.remote.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
        val baseurl = "https://newsapi.org/"
        fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .build()
        }
        val api:ApiService = getRetrofit().create(ApiService::class.java)
    }
}