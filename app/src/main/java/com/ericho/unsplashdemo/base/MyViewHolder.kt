package com.ericho.unsplashdemo.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.ericho.unsplashdemo.BR

class MyViewHolder(val binding:ViewDataBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(photo:Any){

        binding.apply {
            setVariable(BR.obj,photo)
            executePendingBindings()
        }
    }
}