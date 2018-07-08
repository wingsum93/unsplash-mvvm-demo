package com.ericho.unsplashdemo.data.source.remote

/**
 * Created by steve_000 on 9/7/2018.
 * for project unsplash-mvvm-demo
 * package name com.ericho.unsplashdemo.data.source.remote
 */
data class PhotoResponse (
    val id:String = "",
    val created_at:String= "",
    val updated_at:String= "",
    val color:String = "",

    val urls:Urls,
    val links:Links)
{
    data class Links(
            val self:String,
            val html:String,
            val download:String,
            val download_location:String
    )
    data class Urls(
            val raw:String,
            val full:String,
            val regular:String,
            val small:String,
            val thumb:String
    )
}
