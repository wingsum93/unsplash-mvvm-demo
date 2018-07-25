package com.ericho.unsplashdemo.data.source.local

import android.content.res.Resources
import android.support.annotation.VisibleForTesting
import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.Result
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import com.ericho.unsplashdemo.util.AppExecutors
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch


class PhotoLocalDataSource private constructor(

        val appExecutors: AppExecutors,
        val photoDao: PhotoDao
) : PhotoDataSource {


    override suspend fun getRandomPhoto(): Result<Photo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getPhoto(id: String): Result<Photo> = async {
        val photo = photoDao.getPhoto(id)
        if (photo == null) {
            return@async Result.Failure(Resources.NotFoundException())
        } else {
            return@async Result.Success(photo)
        }
    }.await()

    override suspend fun listPhoto(): Result<List<Photo>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun savePhoto(id: String, photo: Photo) = launch {
        check(id == photo.id)
        photoDao.insertPhoto(photo)
    }.join()

    override suspend fun savePhoto(photos: List<Photo>) {
        photoDao.insertPhotos(photos)
    }

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