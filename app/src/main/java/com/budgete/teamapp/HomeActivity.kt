package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var expenseButton: Button
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize UI elements
        expenseButton = findViewById(R.id.expenseButton)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Set the current item as selected
        bottomNavigation.selectedItemId = R.id.nav_overview

        // Navigate to Add Expense screen
        expenseButton.setOnClickListener {
            val intent = Intent(this, ExpenseActivity::class.java)
            startActivity(intent)
        }

        // Set up bottom navigation actions
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_overview -> {
                    // Already on HomeActivity
                    true
                }
                R.id.nav_budget -> {
                    startActivity(Intent(this, CreateBudgetActivity::class.java))
                    true
                }
                R.id.nav_savings -> {
                    startActivity(Intent(this, SavingsDashboardActivity::class.java))
                    true
                }
                R.id.nav_rewards -> {
                    startActivity(Intent(this, RewardActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileSettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
