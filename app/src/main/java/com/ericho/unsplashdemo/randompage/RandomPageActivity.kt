package com.ericho.unsplashdemo.randompage

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.ericho.unsplashdemo.databinding.ActivityRandomPageBinding
import com.ericho.unsplashdemo.R
import com.ericho.unsplashdemo.util.obtainViewModel
import com.ericho.unsplashdemo.viewimage.ViewImageActivity

class RandomPageActivity :AppCompatActivity(){

    lateinit var adapter: RandomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRandomPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_random_page)

        val model = obtainViewModel(RandomViewModel::class.java)
        setUnAdapter(model)
        subscribeForEvent(model)
        binding.model = model

    }

    private fun subscribeForEvent(model:RandomViewModel) {
        model.apply { 
            val act = this@RandomPageActivity
            imageClickEvent.observe(act,
                    Observer { it-> act.openDetailPage(it) })
        }
    }

    private fun openDetailPage(url: String?) {
        val i = ViewImageActivity.newIntent(this,url!!)
        startActivity(i)
    }

    private fun setUnAdapter( viewModel: RandomViewModel){
        adapter = RandomAdapter(viewModel)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
    }
}