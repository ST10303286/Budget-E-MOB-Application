package com.budgete.teamapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.budgete.teamapp.database.dao.*
import com.budgete.teamapp.database.entities.*

@Database(
    entities = [User::class, Expense::class, Category::class, Goal::class],
    version = 1,
    exportSchema = false
)
abstract class BudgetEDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun categoryDao(): CategoryDao
    abstract fun goalDao(): GoalDao

    companion object {
        @Volatile
        private var INSTANCE: BudgetEDatabase? = null

        fun getInstance(context: Context): BudgetEDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    BudgetEDatabase::class.java,
                    "budgete_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
