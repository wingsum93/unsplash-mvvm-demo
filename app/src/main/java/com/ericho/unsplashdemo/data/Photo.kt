package com.ericho.unsplashdemo.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "photo")
data class Photo @JvmOverloads constructor(
        @ColumnInfo(name = "title") var title: String = "",
        @ColumnInfo(name = "description") var description: String = "",
        @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") var id: Int = 0
) {
}