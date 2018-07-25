package com.ericho.unsplashdemo.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.ericho.unsplashdemo.BuildConfig
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Result
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import kotlinx.coroutines.experimental.launch

class HomeViewModel(app: Application,val photoDataSource: PhotoDataSource) : AndroidViewModel(app) {

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

        function1Text.set("List Latest Image")
        function2Text.set("Other")

        loadOneImage("Hd7vwFzZpH0")
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


    private fun loadOneImage(id:String) = launch {
        val result = photoDataSource.getPhoto(id)
        when(result){
            is Result.Success -> firstImageUrl.set(result.data.link)
            else -> {}
        }
    }
}