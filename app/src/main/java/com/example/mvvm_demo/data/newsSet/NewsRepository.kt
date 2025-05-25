package com.example.mvvm_demo.data.newsSet

import android.content.Context
import androidx.annotation.OpenForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mvvm_demo.api.NewsApi
import com.example.mvvm_demo.api.NewsListModel
import com.example.mvvm_demo.common.PAGE_SIZE
import com.example.mvvm_demo.common.apiKey
import com.example.mvvm_demo.commonUtil.ConnectivityUtil
import com.example.mvvm_demo.data.dao.NewsDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OpenForTesting
class NewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val newsRemoteDataSource: NewsRemoteDataSource,
    @ApplicationContext private val context: Context
) {
    fun observePagedNews()
            : Flow<PagingData<NewsListModel>> {
        val isOnline = ConnectivityUtil.isConnected(context)
        return if (isOnline)
            observeRemotePagedNews()
        else observeLocalPagedNews()
    }

    private fun observeLocalPagedNews(): Flow<PagingData<NewsListModel>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                newsDao.getPagedNews()
            }
        ).flow
    }

    private fun observeRemotePagedNews(): Flow<PagingData<NewsListModel>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = {
                NewsRemotePagingSource(newsRemoteDataSource, apiKey, PAGE_SIZE)
            }
        ).flow
    }
}
