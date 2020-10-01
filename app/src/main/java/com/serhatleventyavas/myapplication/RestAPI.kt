package com.serhatleventyavas.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface RestAPI {

    @GET("/news")
    suspend fun getAllNews(): Response<List<NewsModel>>
}