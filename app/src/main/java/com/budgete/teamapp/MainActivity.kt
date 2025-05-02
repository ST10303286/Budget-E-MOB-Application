package com.budgete.teamapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.budgete.teamapp.database.entities.Category
import com.budgete.teamapp.database.entities.Expense
import com.budgete.teamapp.helpers.AuthHelper
import com.budgete.teamapp.helpers.DatabaseHelper
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase and Room database helpers
        DatabaseHelper.initDatabase(applicationContext)
        AuthHelper.initAuth()

        // Register or log in the user (use one or the other)
        // AuthHelper.registerUser(this, "tester@example.com", "password123")
        AuthHelper.loginUser(this, "tester@example.com", "password123")

        // Insert a sample category (categoryId = 1 must exist)
        DatabaseHelper.insertCategory(
            category = Category(
                userId = 1,
                name = "Test Category",
                iconUrl = null
            )
        )

        // Insert a sample expense for userId = 1 and categoryId = 1
        CoroutineScope(Dispatchers.IO).launch {
            val expense = Expense(
                userId = 1,
                amount = 89.99,
                categoryId = 1,
                date = "2024-05-01",
                startTime = "10:00",
                endTime = "11:00",
                description = "Test lunch",
                photoUrl = null
            )

            DatabaseHelper.insertExpense(expense) {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainActivity, "Expense saved", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Fetch all expenses with category names for a specific date range
        DatabaseHelper.getExpensesWithCategoryByDateRange(
            userId = 1,
            startDate = "2024-05-01",
            endDate = "2024-05-31"
        ) { expensesWithCategory ->
            Toast.makeText(this, "Found ${expensesWithCategory.size} expenses", Toast.LENGTH_SHORT).show()
            expensesWithCategory.forEach {
                Log.d("EXPENSE_TEST", "${it.expense.description} | R${it.expense.amount} | ${it.category.name}")
            }
        }

        // Calculate total spent in a specific category for a given period
        DatabaseHelper.getTotalSpentByCategory(
            userId = 1,
            categoryId = 1,
            startDate = "2024-05-01",
            endDate = "2024-05-31"
        ) { total ->
            val amount = total ?: 0.0
            Toast.makeText(this, "Total spent: R$amount", Toast.LENGTH_LONG).show()
            Log.d("CATEGORY_TOTAL", "Total for category 1: R$amount")
        }
    }
}
 