package com.ericho.unsplashdemo.home

import android.databinding.BindingAdapter
import android.widget.ImageView

object ImageViewBindings {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageRes(imageView: ImageView,drawableRes:Int){
        with(imageView){
            setImageResource(drawableRes)
        }
    }
}