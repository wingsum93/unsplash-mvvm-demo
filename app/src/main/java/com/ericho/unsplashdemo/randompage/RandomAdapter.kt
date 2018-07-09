package com.ericho.unsplashdemo.randompage

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.ericho.androidjsdemo.databinding.RowPhotoBinding
import com.ericho.unsplashdemo.base.MyViewHolder

import com.ericho.unsplashdemo.data.Photo


class RandomAdapter (val items:MutableList<Photo>):RecyclerView.Adapter<RandomAdapter.ViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)

        val itemBinding = RowPhotoBinding.inflate(layoutInflater, p0, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val a = items[p1]
        holder.bind(a)
    }

    inner class ViewHolder(private val mBinding: RowPhotoBinding) : RecyclerView.ViewHolder(mBinding.root) {

        fun bind(photo: Photo) {
            mBinding.obj = photo
            mBinding.executePendingBindings()
        }
    }
}