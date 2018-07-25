package com.ericho.unsplashdemo.viewimage

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ericho.unsplashdemo.R
import com.ericho.unsplashdemo.databinding.ActivityViewImageBinding
import com.ericho.unsplashdemo.util.obtainViewModel

class ViewImageActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityViewImageBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_image)

        val model = obtainViewModel<ViewImageViewModel>()
        binding.model = model


        //get data
        val a = intent.getStringExtra("url")
        model.imageUrl.set(a)
    }

    companion object {

        fun newIntent(context: Context,url:String) = Intent(context,ViewImageActivity::class.java).apply {
            putExtra("url",url)
        }
    }
}