package com.budgete.teamapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goals")
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val minAmount: Double,
    val maxAmount: Double,
    val targetDate: String,
    val savedAmount: Double
)
