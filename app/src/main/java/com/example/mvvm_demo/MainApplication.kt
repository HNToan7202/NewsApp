package com.example.mvvm_demo

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }
}