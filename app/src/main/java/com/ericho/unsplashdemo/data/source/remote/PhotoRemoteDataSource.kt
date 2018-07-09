package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

object PhotoRemoteDataSource : PhotoDataSource {

    val photoService:PhotoService by lazy { PhotoService.Factory.create() }

    override fun getPhoto(callback: PhotoDataSource.PhotoCallback) {

        val z = photoService.getRandomImage()
        z.enqueue(object :Callback<PhotoResponse>{
            override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                callback.onError(t!!)
            }

            override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {

                if (!response!!.isSuccessful) {
                    callback.onError(IOException("code = ${response.code()}"))
                }

                val photoResponse = response.body()
                Timber.d(photoResponse.toString())

                callback.onPhotoLoaded(Photo())
            }
        })
    }
}