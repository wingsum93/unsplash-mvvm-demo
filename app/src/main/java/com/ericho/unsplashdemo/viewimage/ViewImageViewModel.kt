package com.ericho.unsplashdemo.viewimage

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class ViewImageViewModel :ViewModel(){

    val imageUrl : ObservableField<String> = ObservableField("")

}