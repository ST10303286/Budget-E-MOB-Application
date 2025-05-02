package com.budgete.teamapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String,
    val username: String,
    val password: String,
    val profilePictureUrl: String? = null
)
