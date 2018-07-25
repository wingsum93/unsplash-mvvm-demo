package com.ericho.unsplashdemo.category

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.PhotoRepository
import com.ericho.unsplashdemo.util.onSuccess
import kotlinx.coroutines.experimental.launch

/**
 * Created by steve_000 on 6/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.category
 */
class CategoryViewModel(
        private val photoRepository: PhotoRepository
) : ViewModel() {

    val title: ObservableField<String> = ObservableField()
    val imageUrl: ObservableField<String> = ObservableField()
    val currentPhoto: ObservableField<Photo> = ObservableField()
    val imageClickCommand = SingleLiveEvent<String>()


    init {
        loadData()
    }

    private fun loadData() = launch {
        val a = photoRepository.getRandomPhoto()
        a.onSuccess {
            imageUrl.set(it.link)
            currentPhoto.set(it)
        }
    }


    fun onImageClick() {
        imageClickCommand.value = imageUrl.get()
    }
}