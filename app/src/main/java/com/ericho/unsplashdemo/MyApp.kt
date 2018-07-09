package com.ericho.unsplashdemo

import android.app.Application
import com.ericho.androidjsdemo.BuildConfig
import timber.log.Timber

class MyApp :Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}