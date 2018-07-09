package com.ericho.unsplashdemo.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ericho.androidjsdemo.BR
import com.ericho.androidjsdemo.databinding.RowPhotoBinding
import com.ericho.unsplashdemo.data.Photo

class MyViewHolder(val binding:ViewDataBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(photo:Any){

        binding.apply {
            setVariable(BR.obj,photo)
            executePendingBindings()
        }
    }
}