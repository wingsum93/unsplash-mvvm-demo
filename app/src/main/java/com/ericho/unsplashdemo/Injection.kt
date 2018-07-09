package com.ericho.unsplashdemo

import android.content.Context
import com.ericho.unsplashdemo.data.source.PhotoRepository
import com.ericho.unsplashdemo.data.source.local.MyDatabase
import com.ericho.unsplashdemo.data.source.local.PhotoLocalDataSource
import com.ericho.unsplashdemo.data.source.remote.PhotoRemoteDataSource
import com.ericho.unsplashdemo.util.AppExecutors

object Injection {

    fun getPhotoRepository(context: Context): PhotoRepository {
        val database = MyDatabase.getInstance(context)
        return PhotoRepository.getInstance(PhotoRemoteDataSource,
                PhotoLocalDataSource.getInstance(AppExecutors(), database.photoDao()))
    }
}