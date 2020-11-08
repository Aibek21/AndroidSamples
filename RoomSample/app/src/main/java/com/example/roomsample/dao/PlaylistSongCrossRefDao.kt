package com.example.roomsample.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.roomsample.model.PlaylistSongCrossRef

@Dao
interface PlaylistSongCrossRefDao {
    @Insert
    fun insert(playlistSongCrossRef: PlaylistSongCrossRef)
}