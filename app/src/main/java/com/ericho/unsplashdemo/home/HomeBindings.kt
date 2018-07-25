package com.ericho.unsplashdemo.home

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.ericho.unsplashdemo.GlideApp

object ViewBindings {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageRes(imageView: ImageView,drawableRes:Int){
        GlideApp.with(imageView.context)
                .load(drawableRes)
                .into(imageView)
    }
    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        if (url == null) return
        GlideApp.with(imageView.context)
                .load(url)
                .centerCrop()
                .into(imageView)
    }
}