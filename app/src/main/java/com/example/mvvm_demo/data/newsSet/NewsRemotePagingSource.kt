package com.example.mvvm_demo.data.newsSet

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvm_demo.api.NewsListModel
import com.example.mvvm_demo.data.Result

class NewsRemotePagingSource(
    private val remoteDataSource: NewsRemoteDataSource,
    private val apiKey: String,
    private val pageSize: Int
) : PagingSource<Int, NewsListModel>() {

    override fun getRefreshKey(state: PagingState<Int, NewsListModel>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.let { page ->
                page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
            }
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsListModel> {
        val page = params.key ?: 1
        return try {
            val result = remoteDataSource.fetchNewsList(apiKey, page, pageSize)
            if (result is Result.Success) {
                val data = result.data.articles
                LoadResult.Page(
                    data = data,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (data.isEmpty()) null else page + 1
                )
            } else {
                LoadResult.Error(Exception("Unknown error occurred"))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}