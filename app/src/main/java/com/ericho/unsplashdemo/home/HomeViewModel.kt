package com.ericho.unsplashdemo.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.os.Handler
import com.ericho.unsplashdemo.BuildConfig
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import timber.log.Timber

class HomeViewModel(app: Application,photoDataSource: PhotoDataSource) : AndroidViewModel(app) {

    val title: ObservableField<String> = ObservableField()
    val firstImageUrl: ObservableField<String> = ObservableField()
    val function1Text: ObservableField<String> = ObservableField()
    val function2Text: ObservableField<String> = ObservableField()

    val versionName: ObservableField<String> = ObservableField("v"+ BuildConfig.VERSION_NAME)
    @JvmField
    val isActive: ObservableBoolean = ObservableBoolean(false)

    val btn1Command = SingleLiveEvent<Void>()
    val btn2Command = SingleLiveEvent<Void>()
    val imageClickCommand = SingleLiveEvent<String>()


    init {
        firstImageUrl.set("https://www.weetnow.com/wp-content/uploads/2015/08/Orange.jpg")
        function1Text.set("List Latest Image")
        function2Text.set("Other")

        photoDataSource.getPhoto("Hd7vwFzZpH0",object :PhotoDataSource.PhotoCallback{
            override fun onPhotoLoaded(photo: Photo) {
                firstImageUrl.set(photo.link)
            }

            override fun onError(e: Throwable) {
                Timber.w(e)
            }
        })
    }
    fun onClickFriend() {

        btn1Command.call()

    }

    fun onClickFriend2() {

        btn2Command.call()
    }

    fun onImageClick(){
        imageClickCommand.value = firstImageUrl.get()
    }
}