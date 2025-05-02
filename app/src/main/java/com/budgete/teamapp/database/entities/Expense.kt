package com.budgete.teamapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val amount: Double,
    val categoryId: Int,
    val date: String,
    val startTime: String,
    val endTime: String,
    val description: String,
    val photoUrl: String? = null
)
