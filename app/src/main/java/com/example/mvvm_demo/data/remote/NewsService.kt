package com.example.mvvm_demo.data.remote

import com.example.mvvm_demo.api.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/v2/everything")
    suspend fun getTopNewsList(
        @Query("apiKey") apiKey: String? = null,
        @Query("page") page: Int? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("q") source: String? = null
    ): Response<NewsListResponse>
}