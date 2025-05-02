package com.budgete.teamapp.database.dao

import androidx.room.*
import com.budgete.teamapp.database.entities.Goal

@Dao
interface GoalDao {
    @Insert
    suspend fun insertGoal(goal: Goal)

    @Query("SELECT * FROM goals WHERE userId = :userId")
    suspend fun getGoalsByUser(userId: Int): List<Goal>

    @Delete
    suspend fun deleteGoal(goal: Goal)
}
