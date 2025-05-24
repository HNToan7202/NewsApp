package com.example.mvvm_demo.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.mvvm_demo.MainApplication
import com.example.mvvm_demo.api.NewsApi
import com.example.mvvm_demo.api.RetrofitFactory
import com.example.mvvm_demo.data.AppDatabase
import com.example.mvvm_demo.data.newsSet.NewsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesNewsService(): NewsApi = RetrofitFactory.getNewsService()

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsService: NewsApi) = NewsRemoteDataSource(newsService)

    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideNewsSetDao(db: AppDatabase) = db.getNewsListDao()
}