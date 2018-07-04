package com.ericho.unsplashdemo.data.source

class PhotoRepository(
        val photoRemoteDataSource: PhotoDataSource,
        val photoLocalDataSource: PhotoDataSource
) : PhotoDataSource {


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