package com.ericho.unsplashdemo.randompage

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ericho.androidjsdemo.R
import com.ericho.androidjsdemo.databinding.ActivityMainBinding
import com.ericho.unsplashdemo.home.HomeViewModel
import com.ericho.unsplashdemo.util.obtainViewModel

class RandomPageActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_random_page)

        val model = obtainViewModel(RandomViewModel::class.java)

    }
}