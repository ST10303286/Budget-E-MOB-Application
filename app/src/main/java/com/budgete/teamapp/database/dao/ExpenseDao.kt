package com.budgete.teamapp.database.dao

import androidx.room.*
import com.budgete.teamapp.database.entities.Expense
import com.budgete.teamapp.database.entities.ExpenseWithCategory

@Dao
interface ExpenseDao {

    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses WHERE userId = :userId AND date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    suspend fun getExpensesByDateRange(userId: Int, startDate: String, endDate: String): List<Expense>

    @Query("SELECT * FROM expenses WHERE userId = :userId ORDER BY date DESC")
    suspend fun getAllExpensesForUser(userId: Int): List<Expense>

    @Query("SELECT SUM(amount) FROM expenses WHERE userId = :userId AND categoryId = :categoryId AND date BETWEEN :startDate AND :endDate")
    suspend fun getTotalSpentForCategory(userId: Int, categoryId: Int, startDate: String, endDate: String): Double?

    @Transaction
    @Query("""
        SELECT * FROM expenses 
        WHERE userId = :userId AND date BETWEEN :startDate AND :endDate 
        ORDER BY date DESC
    """)
    suspend fun getExpensesWithCategoryByDateRange(
        userId: Int,
        startDate: String,
        endDate: String
    ): List<ExpenseWithCategory>
}
