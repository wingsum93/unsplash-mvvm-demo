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

    override fun listPhoto(callback: PhotoDataSource.LoadPhotoCallback) {
        val aaaCall = photoService.listPhoto()
        aaaCall.enqueue(object :Callback<List<PhotoResponse>>{
            override fun onFailure(call: Call<List<PhotoResponse>>?, t: Throwable?) {
                callback.onError(t!!)
            }

            override fun onResponse(call: Call<List<PhotoResponse>>?, response: Response<List<PhotoResponse>>?) {
                if (!response!!.isSuccessful) {
                    callback.onError(IOException("code = ${response.code()}"))
                }

                val list = response.body()

                Timber.d("ABC")

                val newList = list?.map { it.toPhoto() } ?: listOf()
                callback.onPhotoLoaded(newList)
            }
        })
    }

    override fun getPhoto(id: String, callback: PhotoDataSource.PhotoCallback) {
        val z = photoService.getPhoto(id)
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
}