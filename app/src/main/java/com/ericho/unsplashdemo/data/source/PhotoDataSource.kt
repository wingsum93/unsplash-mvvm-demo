package com.ericho.unsplashdemo.data.source

import com.ericho.unsplashdemo.data.Photo

interface PhotoDataSource {


    fun getPhoto(callback: PhotoCallback)


    interface PhotoCallback{

        fun onPhotoLoaded(photo:Photo)

        fun onError(e:Throwable)
    }
}