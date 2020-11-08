package com.example.roomsample.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.roomsample.model.Library
import com.example.roomsample.model.User

@Dao
interface LibraryDao {
    @Insert
    fun insert(library: Library): Long
}