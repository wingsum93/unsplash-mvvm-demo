package com.ericho.unsplashdemo.category

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * Created by steve_000 on 6/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.category
 */
class CategoryViewModel :ViewModel() {

    val title: ObservableField<String> = ObservableField()
    val firstImageUrl: ObservableField<String> = ObservableField()
    val secondImageUrl: ObservableField<String> = ObservableField()

}