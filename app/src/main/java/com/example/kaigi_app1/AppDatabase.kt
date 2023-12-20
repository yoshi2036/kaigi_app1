package com.example.kaigi_app1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int,

    val firstName: String?,
    val lastName: String?

)