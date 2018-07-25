package com.ericho.unsplashdemo.data.source

import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.Result

interface PhotoDataSource {


    suspend fun getRandomPhoto():Result<Photo>
    suspend fun getPhoto(id:String):Result<Photo>

    suspend fun listPhoto():Result<List<Photo>>


}