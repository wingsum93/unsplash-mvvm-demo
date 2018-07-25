package com.ericho.unsplashdemo.viewimage

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

@Deprecated("")
class ViewImageViewModel :ViewModel(){

    val imageUrl : ObservableField<String> = ObservableField("")

}