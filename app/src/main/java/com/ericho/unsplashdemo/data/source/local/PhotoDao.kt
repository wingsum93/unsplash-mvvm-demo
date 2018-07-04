package com.ericho.unsplashdemo.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ericho.unsplashdemo.data.Photo


@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo")
    fun getTasks(): List<Photo>
}