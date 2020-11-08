package com.example.roomsample.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.roomsample.model.Library
import com.example.roomsample.model.Playlist
import com.example.roomsample.model.PlaylistWithSongs

@Dao
interface PlaylistDao {
    @Insert
    fun insert(playlist: Playlist): Long


    @Transaction
    @Query("SELECT * FROM Playlist")
    fun getPlaylistsWithSongs(): List<PlaylistWithSongs>
}