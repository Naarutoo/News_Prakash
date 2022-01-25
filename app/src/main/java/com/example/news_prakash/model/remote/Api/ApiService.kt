package com.example.news_prakash.model.remote.Api

import com.example.news_prakash.model.remote.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getData(@Query("country")country:String,@Query("apiKey")key:String): ResponseModel
}

