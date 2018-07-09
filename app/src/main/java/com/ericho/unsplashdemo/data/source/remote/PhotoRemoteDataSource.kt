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

    override fun getRandomPhoto(callback: PhotoDataSource.PhotoCallback) {

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

                val newP = photoResponse!!.toPhoto()

                callback.onPhotoLoaded(newP)
            }
        })
    }

    override fun getPhoto(id: String, callback: PhotoDataSource.PhotoCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}