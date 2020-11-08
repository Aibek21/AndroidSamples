package com.example.roomsample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey(autoGenerate = true) var songId: Long? = null,
    var songName: String? = null,
    var artist: String? = null
)