package com.ericho.unsplashdemo.randompage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.ericho.unsplashdemo.databinding.RowPhotoBinding
import com.ericho.unsplashdemo.data.Photo


class RandomAdapter (val viewModel: RandomViewModel):RecyclerView.Adapter<RandomAdapter.ViewHolder>(){

    val items:MutableList<Photo> = mutableListOf()

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

        val listener =object :PhotoClickListener{
            override fun onPhotoClicked(photo: Photo) {
                viewModel.imageClickEvent.value = photo.link
            }
        }
        with(holder.binding){
            setVariable(BR.obj,a)
            setVariable(BR.listener,listener)
            executePendingBindings()
        }
    }


    fun replaceData(items:List<Photo>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    inner class ViewHolder(val binding: RowPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.setVariable(BR.obj,photo)
            binding.executePendingBindings()
        }

    }
}