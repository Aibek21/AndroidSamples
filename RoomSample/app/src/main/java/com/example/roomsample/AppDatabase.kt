package com.example.roomsample

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomsample.dao.*
import com.example.roomsample.model.*

@Database(
    entities = arrayOf(
        User::class,
        Library::class,
        Playlist::class,
        Song::class,
        PlaylistSongCrossRef::class
    ), version = 11
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun libraryDao(): LibraryDao
    abstract fun playlistDao(): PlaylistDao
    abstract fun songDao(): SongDao
    abstract fun playlistSongCrossRefDao(): PlaylistSongCrossRefDao
}