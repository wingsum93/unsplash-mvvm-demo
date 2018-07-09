package com.ericho.unsplashdemo.randompage

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.ericho.unsplashdemo.data.Photo

object CustomBinding {

    @BindingAdapter("app:photos")
    @JvmStatic
    fun replace(recyclerView: RecyclerView,items:List<Photo>){
        with(recyclerView.adapter as RandomAdapter){
            replaceData(items)
        }

    }
}