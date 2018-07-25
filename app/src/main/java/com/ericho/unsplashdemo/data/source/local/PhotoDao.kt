package com.ericho.unsplashdemo.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.ericho.unsplashdemo.data.Photo


@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo")
    fun getAllPhoto(): List<Photo>

    @Query("SELECT * FROM Photo where id = :id ")
    fun getPhoto(id: String): Photo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: Photo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photos: List<Photo>)



}