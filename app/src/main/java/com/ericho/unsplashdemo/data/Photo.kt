package com.ericho.unsplashdemo.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "photo")
data class Photo @JvmOverloads constructor(
        @ColumnInfo(name = "likes") var likes: Int = 0,
        @ColumnInfo(name = "downloads") var downloads: Int = 0,
        @ColumnInfo(name = "description") var description: String = "",
        @ColumnInfo(name = "link") var link: String = "",
        @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") var id: String = ""
) {
}