package com.ericho.unsplashdemo.category

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ericho.unsplashdemo.R
import com.ericho.unsplashdemo.databinding.ActivityCategoryBinding
import com.ericho.unsplashdemo.util.obtainViewModel
import com.ericho.unsplashdemo.viewimage.ViewImageActivity
import timber.log.Timber

/**
 * Created by steve_000 on 6/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.category
 */
class CategoryActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCategoryBinding = DataBindingUtil.setContentView(this, R.layout.activity_category)

        val model = obtainViewModel(CategoryViewModel::class.java)
        binding.model = model

        subscribeListener(model)
    }

    private fun subscribeListener(model: CategoryViewModel) {
        val act = this@CategoryActivity
        model.run {
            imageClickCommand.observe(act,
                    Observer { link -> act.onImageClick(link) })
        }
    }

    private fun onImageClick(link: String?) {
        link?.apply {
            Timber.d("link clicked: $link")
            val i = ViewImageActivity.newIntent(this@CategoryActivity, link)
            startActivity(i)
        }
    }
}