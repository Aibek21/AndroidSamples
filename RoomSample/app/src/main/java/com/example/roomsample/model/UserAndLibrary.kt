package com.example.roomsample.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndLibrary(
    @Embedded val user: User,
    @Relation(
        parentColumn = "uid",
        entityColumn = "userOwnerId"
    )
    val library: Library
)