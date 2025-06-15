package com.example.mvvm_demo.data

import android.content.Context
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkInterceptor : Interceptor {
    @Inject
    lateinit var context: Context

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .build()

        // Log cURL with tag OKURL
        val url = request.url.toString()
        val headers = request.headers.toString()

        Log.d("OKURL", "cURL: curl -X ${request.method} \"$url\" -H \"${headers}\"")

        return chain.proceed(request)
    }
}