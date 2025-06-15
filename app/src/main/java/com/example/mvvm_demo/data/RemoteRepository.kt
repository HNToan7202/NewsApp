package com.example.mvvm_demo.data

import com.example.mvvm_demo.api.NewsListResponse
import com.example.mvvm_demo.common.apiKey
import com.example.mvvm_demo.data.remote.NewsService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(
    private val newsService: NewsService
) {
    suspend fun getTopNewList(page: Int, pageSize: Int, q: String): Response<NewsListResponse> {
        return newsService.getTopNewsList(apiKey = apiKey, page = page, pageSize = pageSize, q)
    }
}