package com.ericho.unsplashdemo.randompage

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.ericho.unsplashdemo.R
import com.ericho.unsplashdemo.databinding.ActivityImageListBinding
import com.ericho.unsplashdemo.util.obtainViewModel
import com.ericho.unsplashdemo.viewimage.ViewImageActivity

class ImageListActivity : AppCompatActivity() {

    lateinit var adapter: RandomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityImageListBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_list)

        val model = obtainViewModel(ImageListViewModel::class.java)
        setUnAdapter(model)
        subscribeForEvent(model)
        binding.model = model

    }

    private fun subscribeForEvent(model: ImageListViewModel) {
        model.apply {
            val act = this@ImageListActivity
            imageClickEvent.observe(act,
                    Observer { it-> act.openDetailPage(it) })
        }
    }

    private fun openDetailPage(url: String?) {
        val i = ViewImageActivity.newIntent(this,url!!)
        startActivity(i)
    }

    private fun setUnAdapter(viewModel: ImageListViewModel) {
        adapter = RandomAdapter(viewModel)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
    }
}