package com.ericho.unsplashdemo.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Observer
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.os.Handler
import com.ericho.androidjsdemo.BuildConfig
import com.ericho.androidjsdemo.R
import com.ericho.unsplashdemo.SingleLiveEvent

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    val title: ObservableField<String> = ObservableField()
    val title2: ObservableField<String> = ObservableField()
    val bigImageRes: ObservableInt = ObservableInt(R.drawable.denys_nevozhai_154989_unsplash)
    val smallImageRes: ObservableInt = ObservableInt(R.drawable.adorable_animal_breed_356378)
    val versionName: ObservableField<String> = ObservableField("v"+BuildConfig.VERSION_NAME)
    @JvmField
    val isActive: ObservableBoolean = ObservableBoolean(false)

    val btn1Command = SingleLiveEvent<Void>()
    val btn2Command = SingleLiveEvent<Void>()

    private lateinit var handler:Handler

    init {
        handler = Handler()
        handler.postDelayed({
            isActive.set(true)
        },3000)
    }
    fun onClickFriend() {

        btn1Command.call()

    }

    fun onClickFriend2() {

        btn2Command.call()
    }
}