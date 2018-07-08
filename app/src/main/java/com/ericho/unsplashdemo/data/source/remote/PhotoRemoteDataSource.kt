package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.data.source.PhotoDataSource

object PhotoRemoteDataSource : PhotoDataSource {

    val photoService:PhotoService by lazy { PhotoService.Factory.create() }
}