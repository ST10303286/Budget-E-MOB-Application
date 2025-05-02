package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SavingsRulesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_rules)

        // Initialize Rule Buttons
        val spendLessRuleButton = findViewById<Button>(R.id.spendLessRuleButton)
        val twoWeekRuleButton = findViewById<Button>(R.id.twoWeekRuleButton)
        val guiltyPleasureRuleButton = findViewById<Button>(R.id.guiltyPleasureRuleButton)
        val ifNotThisThenThatButton = findViewById<Button>(R.id.ifNotThisThenThatButton)

        // Initialize Goal Buttons
        val buyCarButton = findViewById<Button>(R.id.buyCarButton)
        val buyIphoneButton = findViewById<Button>(R.id.buyIphoneButton)
        val vacationButton = findViewById<Button>(R.id.vacationButton)
        val housingButton = findViewById<Button>(R.id.housingButton)

        // Set up click listeners for Rule Buttons
        spendLessRuleButton.setOnClickListener {
            navigateToRuleDetails("Spend Less Rule")
        }

        twoWeekRuleButton.setOnClickListener {
            navigateToRuleDetails("Two Week Rule")
        }

        guiltyPleasureRuleButton.setOnClickListener {
            navigateToRuleDetails("Guilty Pleasure Rule")
        }

        ifNotThisThenThatButton.setOnClickListener {
            navigateToRuleDetails("If Not This Then That Rule")
        }

        // Set up click listeners for Goal Buttons
        buyCarButton.setOnClickListener {
            navigateToGoalDetails("Buy Car")
        }

        buyIphoneButton.setOnClickListener {
            navigateToGoalDetails("Buy iPhone")
        }

        vacationButton.setOnClickListener {
            navigateToGoalDetails("Vacation")
        }

        housingButton.setOnClickListener {
            navigateToGoalDetails("Housing")
        }
    }

    /**
     * Navigates to the Rule Details screen.
     */
    private fun navigateToRuleDetails(ruleType: String) {
        val intent = Intent(this, RuleDetailsActivity::class.java)
        intent.putExtra("RULE_TYPE", ruleType) // Pass the selected rule type to the next activity
        startActivity(intent)
    }

    /**
     * Navigates to the Goal Details screen.
     */
    private fun navigateToGoalDetails(goalType: String) {
        val intent = Intent(this, GoalDetailsActivity::class.java)
        intent.putExtra("GOAL_TYPE", goalType) // Pass the selected goal type to the next activity
        startActivity(intent)
    }
}