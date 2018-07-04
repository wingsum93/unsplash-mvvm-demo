package com.ericho.unsplashdemo.randompage

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import com.ericho.unsplashdemo.SingleLiveEvent

class RandomViewModel :ViewModel() {

    val title: Observer<String> = Observer { }
    val title2: Observer<String> = Observer { }

    val btn1Command = SingleLiveEvent<Void>()
    val btn2Command = SingleLiveEvent<Void>()

}