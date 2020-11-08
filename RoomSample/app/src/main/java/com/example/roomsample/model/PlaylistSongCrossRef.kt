package com.example.roomsample.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    primaryKeys = ["playlistId", "songId"],
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Playlist::class,
            parentColumns = arrayOf("playlistId"),
            childColumns = arrayOf("playlistId")
        ),
        ForeignKey(
            entity = Song::class,
            parentColumns = arrayOf("songId"),
            childColumns = arrayOf("songId")
        )
    )
)

data class PlaylistSongCrossRef(
    var playlistId: Long,
    var songId: Long
)