package com.example.roomsample.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = arrayOf(
        ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("userCreatorId"),
            onDelete = CASCADE
        )
    )
)
data class Playlist(
    @PrimaryKey(autoGenerate = true) var playlistId: Long? = null,
    var userCreatorId: Long? = null,
    var playlistName: String? = null
)