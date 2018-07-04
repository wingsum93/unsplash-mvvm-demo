package com.ericho.unsplashdemo.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.ericho.androidjsdemo.R
import com.ericho.androidjsdemo.databinding.ActivityMainBinding
import com.ericho.unsplashdemo.util.obtainViewModel


class HomeActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model = obtainViewModel(HomeViewModel::class.java)
        binding.handler = model
        button = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)

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
