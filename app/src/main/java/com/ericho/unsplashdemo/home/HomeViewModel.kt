package com.ericho.unsplashdemo.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.os.Handler
import com.ericho.androidjsdemo.BuildConfig
import com.ericho.androidjsdemo.R
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.PhotoDataSource

class HomeViewModel(app: Application,photoDataSource: PhotoDataSource) : AndroidViewModel(app) {

    val title: ObservableField<String> = ObservableField()
    val firstImageUrl: ObservableField<String> = ObservableField()
    val secondImageUrl: ObservableField<String> = ObservableField()
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
        firstImageUrl.set("https://www.weetnow.com/wp-content/uploads/2015/08/Orange.jpg")
        secondImageUrl.set("https://www.weetnow.com/wp-content/uploads/2015/11/shampoo_1444514a.jpg")

        photoDataSource.getRandomPhoto(object :PhotoDataSource.PhotoCallback{
            override fun onPhotoLoaded(photo: Photo) {
                firstImageUrl.set(photo.link)
            }

            override fun onError(e: Throwable) {

            }
        })
    }
    fun onClickFriend() {

        btn1Command.call()

    }

    fun onClickFriend2() {

        btn2Command.call()
    }
}