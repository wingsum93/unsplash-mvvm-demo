package com.ericho.unsplashdemo.data.source.local

import android.support.annotation.VisibleForTesting
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import com.ericho.unsplashdemo.util.AppExecutors

class PhotoLocalDataSource private constructor(

        val appExecutors: AppExecutors,
        val photoDao: PhotoDao
) : PhotoDataSource {


    companion object {
        private var INSTANCE: PhotoLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, photoDao: PhotoDao): PhotoLocalDataSource {
            if (INSTANCE == null) {
                synchronized(PhotoLocalDataSource::javaClass) {
                    INSTANCE = PhotoLocalDataSource(appExecutors, photoDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}