package com.ericho.unsplashdemo.data.source

import com.ericho.unsplashdemo.data.Photo

interface PhotoDataSource {


    fun getRandomPhoto(callback: PhotoCallback)
    fun getPhoto(id:String,callback: PhotoCallback)

    fun listPhoto(callback: LoadPhotoCallback)


    interface PhotoCallback{

        fun onPhotoLoaded(photo:Photo)

        fun onError(e:Throwable)
    }

    interface LoadPhotoCallback{

        fun onPhotoLoaded(photos:List<Photo>)

        fun onError(e:Throwable)
    }
}