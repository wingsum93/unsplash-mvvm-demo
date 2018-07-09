package com.ericho.unsplashdemo.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.ericho.unsplashdemo.R
import com.ericho.unsplashdemo.category.CategoryActivity
import com.ericho.unsplashdemo.databinding.ActivityHomeBinding
import com.ericho.unsplashdemo.randompage.RandomPageActivity
import com.ericho.unsplashdemo.util.obtainViewModel
import com.ericho.unsplashdemo.viewimage.ViewImageActivity
import timber.log.Timber


open class HomeActivity : AppCompatActivity() {


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
            imageClickCommand.observe(act,
                    Observer { link -> act.onImageClick(link) })
        }
    }

    private fun onImageClick(link: String?) {
        link?.apply {
            Timber.d("link clicked: $link")
            val i = ViewImageActivity.newIntent(this@HomeActivity,link)
            startActivity(i)
        }
    }

    private fun onBtn2Click() {
        startActivity(Intent(this, CategoryActivity::class.java))
    }

    private fun onBtn1Click() {
        startActivity(Intent(this, RandomPageActivity::class.java))
    }


}
