package com.ericho.unsplashdemo.data.source

import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.remote.PhotoResponse

class PhotoRepository(
        private val photoRemoteDataSource: PhotoDataSource,
        private val photoLocalDataSource: PhotoDataSource
) : PhotoDataSource {

    private val cache:MutableMap<String,Photo> = mutableMapOf()



    override fun getRandomPhoto(callback: PhotoDataSource.PhotoCallback) {

        if (cache.get("random") !=null){
            val a = cache.get("random")
            return callback.onPhotoLoaded(a!!)
        }


        photoRemoteDataSource.getRandomPhoto(object :PhotoDataSource.PhotoCallback{
            override fun onPhotoLoaded(photo: Photo) {
                cache.put("random",photo)
                callback.onPhotoLoaded(photo)
            }

            override fun onError(e: Throwable) {
                callback.onError(e)
            }
        })
    }

    override fun getPhoto(id: String, callback: PhotoDataSource.PhotoCallback) {
        if (cache.get(id) !=null){
            val a = cache.get(id)
            return callback.onPhotoLoaded(a!!)
        }

        photoRemoteDataSource.getPhoto(id,object :PhotoDataSource.PhotoCallback{
            override fun onPhotoLoaded(photo: Photo) {
                cache.put(id,photo)
                callback.onPhotoLoaded(photo)
            }

            override fun onError(e: Throwable) {
                callback.onError(e)
            }
        })
    }

    override fun listPhoto(callback: PhotoDataSource.LoadPhotoCallback) {
        photoRemoteDataSource.listPhoto( callback)
    }

    companion object {

        private var INSTANCE: PhotoRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [TasksRepository] instance
         */
        @JvmStatic
        fun getInstance(photoRemoteDataSource: PhotoDataSource,
                        photoLocalDataSource: PhotoDataSource) =
                INSTANCE ?: synchronized(PhotoRepository::class.java) {
                    INSTANCE ?: PhotoRepository(photoRemoteDataSource, photoLocalDataSource)
                            .also { INSTANCE = it }
                }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}