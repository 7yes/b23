package com.example.myapplication.Service

import com.example.myapplication.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getDosByBreed(@Url url:String):Response<DogsResponse>
}