package com.example.mvvm_demo.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_demo.api.NewsListModel

@Dao
interface NewsDao {
    @Query("Select * from NewsListModel")
    fun getNews(): LiveData<List<NewsListModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(news: NewsListModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(newsList: List<NewsListModel>)

    @Query("SELECT * FROM NewsListModel")
    fun getPagedNews(): PagingSource<Int, NewsListModel>
}
