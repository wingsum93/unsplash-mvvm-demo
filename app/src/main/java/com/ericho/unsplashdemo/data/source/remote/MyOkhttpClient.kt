package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.data.base.MyHttpInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by steve_000 on 9/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.data.source.remote
 */
object MyOkhttpClient {

    private var INSTANCE:OkHttpClient? = null
    @JvmStatic
    fun getInstance():OkHttpClient =
        INSTANCE ?:synchronized(MyOkhttpClient::class.java){
            INSTANCE ?: generateDefaultClient().also {
                INSTANCE = it
            }
        }

    private fun generateDefaultClient():OkHttpClient{
        val builder = OkHttpClient.Builder()
        builder.apply {
            connectTimeout(10,TimeUnit.SECONDS)
            addInterceptor(MyHttpInterceptor())
            addNetworkInterceptor(StethoInterceptor())
        }
        return builder.build()
    }

}