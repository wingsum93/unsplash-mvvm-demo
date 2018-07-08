package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.IConstant
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by steve_000 on 9/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.data.source.remote
 * @see <a href="https://unsplash.com/documentation#get-a-random-photo">Unsplash API</a>
 */
interface PhotoService {

    @GET("/photos/")
    fun getPhoto(@Query("id") id:String):Call<PhotoResponse>
    @GET("/photos/random")
    fun getRandomImage():Call<PhotoResponse>



    companion object Factory{


        fun create():PhotoService{
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .client(MyOkhttpClient.getInstance())
                    .baseUrl(IConstant.BASE_URL)
                    .build()

            return retrofit.create(PhotoService::class.java)
        }
    }
}