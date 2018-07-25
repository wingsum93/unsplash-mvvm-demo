package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.data.Photo
import com.ericho.unsplashdemo.data.Result
import com.ericho.unsplashdemo.data.source.PhotoDataSource
import timber.log.Timber
import java.io.IOException
import kotlin.coroutines.experimental.suspendCoroutine

object PhotoRemoteDataSource : PhotoDataSource {

    val photoService:PhotoService by lazy { PhotoService.Factory.create() }


    override suspend fun getRandomPhoto(): Result<Photo>  = suspendCoroutine {
        val z = photoService.getRandomImage()
        val response = z.execute()
        if (response.isSuccessful.not()){
            it.resume(Result.Failure(IOException("connection code: ${response.code()}")))
        }

        val photo = response.body()!!.toPhoto()
        it.resume(Result.Success(photo))
    }
    override suspend fun getPhoto(id: String): Result<Photo>  = suspendCoroutine {
        val z = photoService.getPhoto(id)
        val response = z.execute()
        if (response.isSuccessful.not()){
            it.resume(Result.Failure(IOException("connection code: ${response.code()}")))
        }

        val photo = response.body()!!.toPhoto()
        it.resume(Result.Success(photo))
    }

    override suspend fun listPhoto(): Result<List<Photo>> = suspendCoroutine{
        val z = photoService.listPhoto()
        val response = z.execute()
        if (response.isSuccessful.not()){
            it.resume(Result.Failure(IOException("connection code: ${response.code()}")))
        }

        val list = response.body()

        Timber.d("ABC")

        val newList = list?.map { it.toPhoto() } ?: listOf()
        it.resume(Result.Success(newList))
    }
}