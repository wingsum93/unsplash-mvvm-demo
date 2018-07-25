package com.ericho.unsplashdemo.data.source

import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.Result

class PhotoRepository(
        private val photoRemoteDataSource: PhotoDataSource,
        private val photoLocalDataSource: PhotoDataSource
) : PhotoDataSource {

    private val cache:MutableMap<String,Photo> = mutableMapOf()



    override suspend fun getRandomPhoto(): Result<Photo> {
        if (cache["random"] !=null){
            val a = cache["random"]!!
            return Result.Success(a)
        }
        val r = photoRemoteDataSource.getRandomPhoto()
        when(r){
            is Result.Success ->{
                cache["random"] = r.data
            }
        }
        return r
    }

    override suspend fun getPhoto(id: String): Result<Photo> {
        if (cache[id] !=null){
            val a = cache[id]!!
            return Result.Success(a)
        }

        val r = photoRemoteDataSource.getRandomPhoto()
        when(r){
            is Result.Success -> cache[id] = r.data
        }
        return r
    }

    override suspend fun listPhoto(): Result<List<Photo>> {
        //todo find local cache

        //
        val r = photoRemoteDataSource.listPhoto()
        when(r){
            is Result.Success ->{
                // cache to local
            }
        }
        return r
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