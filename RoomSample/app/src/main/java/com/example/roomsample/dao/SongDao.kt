package com.example.roomsample.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.roomsample.model.Library
import com.example.roomsample.model.Song

@Dao
interface SongDao {
    @Insert
    fun insert(song: Song): Long
}