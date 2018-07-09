package com.ericho.unsplashdemo.data.source.remote

import com.ericho.unsplashdemo.IConstant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by steve_000 on 9/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.data.source.remote
 * @see <a href="https://unsplash.com/documentation#get-a-random-photo">Unsplash API</a>
 */
interface PhotoService {

    @GET("/photos/{id}")
    fun getPhoto(@Path("id") id:String):Call<PhotoResponse>
    @GET("/photos/random")
    fun getRandomImage():Call<PhotoResponse>



    companion object Factory{


        fun create():PhotoService{
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(MyOkhttpClient.getInstance())
                    .baseUrl(IConstant.BASE_URL)
                    .build()

            return retrofit.create(PhotoService::class.java)
        }
    }
}