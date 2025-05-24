package com.example.mvvm_demo.data.newsSet

import androidx.annotation.OpenForTesting
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.paging.LivePagedListBuilder
import com.example.mvvm_demo.api.Data
import com.example.mvvm_demo.api.NetworkState
import com.example.mvvm_demo.api.NewsListModel
import com.example.mvvm_demo.data.dao.NewsDao
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OpenForTesting
class NewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val newsRemoteDataSource: NewsRemoteDataSource
) {

    fun observePagedNews(connectivityAvailable: Boolean, coroutineScope: CoroutineScope)
            : Data<NewsListModel> {

        return if (connectivityAvailable)
            observeRemotePagedNews(coroutineScope)
        else observeLocalPagedNews()
    }

    private fun observeLocalPagedNews(): Data<NewsListModel> {

        val dataSourceFactory = newsDao.getPagedNews()

        val createLD = MutableLiveData<NetworkState>()
        createLD.postValue(NetworkState.LOADED)

        return Data(
            LivePagedListBuilder(
                dataSourceFactory,
                NewsPageDataSourceFactory.Companion.pagedListConfig()
            ).build(), createLD
        )
    }

    private fun observeRemotePagedNews(ioCoroutineScope: CoroutineScope): Data<NewsListModel> {
        val dataSourceFactory = NewsPageDataSourceFactory(
            newsRemoteDataSource,
            newsDao, ioCoroutineScope
        )
        val networkState = dataSourceFactory.liveData.switchMap {
            it.networkState
        }
        return Data(
            LivePagedListBuilder(
                dataSourceFactory,
                NewsPageDataSourceFactory.Companion.pagedListConfig()
            ).build(), networkState
        )
    }
}
