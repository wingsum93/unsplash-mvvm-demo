package com.ericho.unsplashdemo.home

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ericho.androidjsdemo.R
import com.ericho.androidjsdemo.databinding.ActivityHomeBinding
import com.ericho.unsplashdemo.util.obtainViewModel


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val model = obtainViewModel(HomeViewModel::class.java)
        binding.model = model

        subscribeListener(model)

    }

    private fun subscribeListener(model: HomeViewModel) {
        val act = this@HomeActivity
        model.run {
            btn1Command.observe(act,
                    Observer { act.onBtn1Click() })
            btn2Command.observe(act,
                    Observer { act.onBtn2Click() })
        }
    }

    private fun onBtn2Click() {
//        startActivity(Intent(this, JavascriptActivity2::class.java))
    }

    private fun onBtn1Click() {
//        startActivity(Intent(this, JavascriptActivity::class.java))
    }
}
