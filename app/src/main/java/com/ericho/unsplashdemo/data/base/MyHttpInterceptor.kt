package com.ericho.unsplashdemo.data.base

import com.ericho.androidjsdemo.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by steve_000 on 9/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.data.base
 */
class MyHttpInterceptor:Interceptor{

    override fun intercept(chain: Interceptor.Chain?): Response {

        val request = chain!!.request()

        val newReq = request.newBuilder()
                .addHeader("Accept-Version"," v1")
                .addHeader("Authorization","Client-ID ${BuildConfig.SPLASH_ACCESS_KEY}")
                .build()

        return chain.proceed(newReq)
    }
}