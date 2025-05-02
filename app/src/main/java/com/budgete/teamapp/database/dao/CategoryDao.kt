package com.budgete.teamapp.database.dao

import androidx.room.*
import com.budgete.teamapp.database.entities.Category

@Dao
interface CategoryDao {
    @Insert
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM categories WHERE userId = :userId")
    suspend fun getCategoriesByUser(userId: Int): List<Category>

    @Delete
    suspend fun deleteCategory(category: Category)
}
