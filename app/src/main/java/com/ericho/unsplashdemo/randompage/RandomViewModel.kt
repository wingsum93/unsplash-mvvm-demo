package com.ericho.unsplashdemo.randompage

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.ericho.unsplashdemo.SingleLiveEvent
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.Result
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import com.ericho.unsplashdemo.data.source.PhotoRepository
import kotlinx.coroutines.experimental.launch

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

    private fun loadData() = launch{
        val photos = photoRepository.listPhoto()
        when(photos){
            is Result.Success ->items.apply{
                clear()
                addAll(photos.data)
            }
        }

    }
}