package com.ericho.unsplashdemo.randompage

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.text.method.TextKeyListener.clear
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import com.ericho.unsplashdemo.data.source.PhotoRepository
import java.util.Collections.addAll

class RandomViewModel(
        val photoRepository: PhotoRepository
) :ViewModel() {

    val title: Observer<String> = Observer { }
    val title2: Observer<String> = Observer { }

    val btn1Command = SingleLiveEvent<Void>()
    val btn2Command = SingleLiveEvent<Void>()

    val items: ObservableList<Photo> = ObservableArrayList()
    val items2: ObservableArrayList<Photo> = ObservableArrayList()



    init {
        loadData()
    }

    private fun loadData() {
        photoRepository.listPhoto(object :PhotoDataSource.LoadPhotoCallback{
            override fun onPhotoLoaded(photos: List<Photo>) {
                items.apply{
                    clear()
                    addAll(photos)
                }
            }

            override fun onError(e: Throwable) {

            }
        })
    }
}