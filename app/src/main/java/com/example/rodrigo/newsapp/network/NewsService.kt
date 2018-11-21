package com.example.rodrigo.newsapp.network

import com.example.rodrigo.newsapp.entities.ArticleList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    companion object {
        private const val API_KEY = "apiKey=a5d9c0da2f3e428fa31b4f5aa68a4b54"
    }


    @GET("top-headlines?country=br&$API_KEY")
    fun getTopHeadLines(@Query("country")country: String = "br"): Call<ArticleList>

    @GET("everything?$API_KEY")
    fun getEverything(@Query("q") query: String): Call<ArticleList>


}