package com.ericho.unsplashdemo.randompage

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.ericho.androidjsdemo.R
import com.ericho.androidjsdemo.databinding.ActivityRandomPageBinding
import com.ericho.unsplashdemo.util.obtainViewModel

class RandomPageActivity :AppCompatActivity(){

    lateinit var adapter: RandomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRandomPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_random_page)

        val model = obtainViewModel(RandomViewModel::class.java)


        binding.model = model
        setUnAdapter()
    }

    private fun setUnAdapter(){
        adapter = RandomAdapter()
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
    }
}