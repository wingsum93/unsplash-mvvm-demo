package com.ericho.unsplashdemo.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Observer
import com.ericho.unsplashdemo.SingleLiveEvent

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    val title: Observer<String> = Observer { }
    val title2: Observer<String> = Observer { }

    val btn1Command = SingleLiveEvent<Void>()
    val btn2Command = SingleLiveEvent<Void>()

    fun onClickFriend() {

        btn1Command.call()

    }

    fun onClickFriend2() {

        btn2Command.call()
    }
}