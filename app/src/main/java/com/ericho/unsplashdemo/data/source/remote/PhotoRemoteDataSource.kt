package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.Result
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import kotlin.coroutines.experimental.suspendCoroutine

object PhotoRemoteDataSource : PhotoDataSource {

    private val photoService:PhotoService by lazy { PhotoService.Factory.create() }


    override suspend fun getRandomPhoto(): Result<Photo>  = suspendCoroutine {
        val z = photoService.getRandomImage()
        z.enqueue(object :Callback<PhotoResponse>{
            override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                it.resume(Result.Failure(t))
            }

            override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {
                if (response!!.isSuccessful.not()){
                    it.resume(Result.Failure(IOException("connection code: ${response.code()}")))
                }
                val photo = response.body()!!.toPhoto()
                it.resume(Result.Success(photo))
            }
        })
    }
    override suspend fun getPhoto(id: String): Result<Photo>  = suspendCoroutine {
        val z = photoService.getPhoto(id)
        z.enqueue(object :Callback<PhotoResponse>{
            override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                it.resume(Result.Failure(t))
            }

            override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {
                if (response!!.isSuccessful.not()){
                    it.resume(Result.Failure(IOException("connection code: ${response.code()}")))
                }
                val photo = response.body()!!.toPhoto()
                it.resume(Result.Success(photo))
            }
        })
    }

    override suspend fun listPhoto(): Result<List<Photo>> = suspendCoroutine{
        val z = photoService.listPhoto(per_page = 40)
        z.enqueue(object :Callback<List<PhotoResponse>>{
            override fun onFailure(call: Call<List<PhotoResponse>>?, t: Throwable?) {
                it.resume(Result.Failure(t))
            }

            override fun onResponse(call: Call<List<PhotoResponse>>?, response: Response<List<PhotoResponse>>?) {
                if (response!!.isSuccessful.not()){
                    it.resume(Result.Failure(IOException("connection code: ${response.code()}")))
                }

                val list = response.body()
                Timber.d("ABC")
                val newList = list?.map { it.toPhoto() } ?: listOf()
                it.resume(Result.Success(newList))
            }
        })

    }

    override suspend fun savePhoto(id: String, photo: Photo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun savePhoto(photos: List<Photo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}