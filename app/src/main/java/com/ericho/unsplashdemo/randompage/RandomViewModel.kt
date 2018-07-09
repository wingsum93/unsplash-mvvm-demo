package com.ericho.unsplashdemo.randompage

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import com.ericho.unsplashdemo.data.source.PhotoRepository

class RandomViewModel(
        private val photoRepository: PhotoRepository
) :ViewModel() {

    val title: Observer<String> = Observer { }
    val title2: Observer<String> = Observer { }

    val imageClickEvent = SingleLiveEvent<String>()
    val btn2Command = SingleLiveEvent<Void>()

    val items: ObservableList<Photo> = ObservableArrayList()




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