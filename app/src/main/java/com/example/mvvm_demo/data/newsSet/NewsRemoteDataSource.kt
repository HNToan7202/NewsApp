package com.example.mvvm_demo.data.newsSet

import com.example.mvvm_demo.api.BaseDataSource
import com.example.mvvm_demo.api.NewsApi
import com.example.mvvm_demo.api.NewsListResponse
import com.example.mvvm_demo.common.KEYWORD_BITCOIN
import com.example.mvvm_demo.data.Result
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val api: NewsApi) : BaseDataSource() {

    suspend fun fetchNewsList(apiKey: String, page: Int, pageSize: Int): Result<NewsListResponse> {
        return getResult { api.getTopNewsList(apiKey, page, pageSize, KEYWORD_BITCOIN) }
    }
}
