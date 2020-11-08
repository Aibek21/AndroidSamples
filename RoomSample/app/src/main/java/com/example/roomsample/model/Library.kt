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
            childColumns = arrayOf("userOwnerId"),
            onDelete = CASCADE
        )
    )
)
data class Library(
    @PrimaryKey(autoGenerate = true) var libraryId: Long? = null,
    var title: String? = null,
    var userOwnerId: Long? = null
)