package com.budgete.teamapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val name: String,
    val iconUrl: String? = null
)
