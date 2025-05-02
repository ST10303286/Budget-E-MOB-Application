package com.budgete.teamapp.helpers

import android.content.Context
import com.budgete.teamapp.database.BudgetEDatabase
import com.budgete.teamapp.database.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DatabaseHelper {

    private lateinit var db: BudgetEDatabase

    fun initDatabase(context: Context) {
        db = BudgetEDatabase.getInstance(context)
    }

    // Insert Expense
    fun insertExpense(expense: Expense, onComplete: () -> Unit = {}) {
        CoroutineScope(Dispatchers.IO).launch {
            db.expenseDao().insertExpense(expense)
            onComplete()
        }
    }

    // Insert Category
    fun insertCategory(category: Category, onComplete: () -> Unit = {}) {
        CoroutineScope(Dispatchers.IO).launch {
            db.categoryDao().insertCategory(category)
            onComplete()
        }
    }

    // Insert Goal
    fun insertGoal(goal: Goal, onComplete: () -> Unit = {}) {
        CoroutineScope(Dispatchers.IO).launch {
            db.goalDao().insertGoal(goal)
            onComplete()
        }
    }

    // Get all expenses for user
    fun getAllExpenses(userId: Int, onResult: (List<Expense>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.expenseDao().getAllExpensesForUser(userId)
            CoroutineScope(Dispatchers.Main).launch {
                onResult(data)
            }
        }
    }

    // Get expenses with category by date
    fun getExpensesWithCategoryByDateRange(
        userId: Int,
        startDate: String,
        endDate: String,
        onResult: (List<ExpenseWithCategory>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.expenseDao().getExpensesWithCategoryByDateRange(userId, startDate, endDate)
            CoroutineScope(Dispatchers.Main).launch {
                onResult(data)
            }
        }
    }

    // Get total spent for category
    fun getTotalSpentByCategory(
        userId: Int,
        categoryId: Int,
        startDate: String,
        endDate: String,
        onResult: (Double?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val total = db.expenseDao().getTotalSpentForCategory(userId, categoryId, startDate, endDate)
            CoroutineScope(Dispatchers.Main).launch {
                onResult(total)
            }
        }
    }
}
