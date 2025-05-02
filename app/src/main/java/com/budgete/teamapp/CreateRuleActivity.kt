package com.budgete.teamapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateRuleActivity : AppCompatActivity() {

    // Declare UI elements as global variables
    private lateinit var spendLessThanInput: EditText
    private lateinit var locationInput: EditText
    private lateinit var durationInput: EditText
    private lateinit var longTermGoalInput: EditText
    private lateinit var buttonCreateRule: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_rule) // Set the layout for this activity

        // Initialize UI elements using the IDs defined in the XML layout
        spendLessThanInput = findViewById(R.id.spendLessThanInput)
        locationInput = findViewById(R.id.locationInput)
        durationInput = findViewById(R.id.durationInput)
        longTermGoalInput = findViewById(R.id.longTermGoalInput)

        // Initialize the "Create Rule" button
        buttonCreateRule = findViewById(R.id.buttonCreateRule)

        // Set up the button click listener
        buttonCreateRule.setOnClickListener {
            handleCreateRule()
        }
    }

    /**
     * Handles the logic when the "Create Rule" button is clicked.
     */
    private fun handleCreateRule() {
        // Retrieve user input
        val spendLessThan = spendLessThanInput.text.toString().trim()
        val location = locationInput.text.toString().trim()
        val duration = durationInput.text.toString().trim()
        val longTermGoal = longTermGoalInput.text.toString().trim()

        // Validate input fields
        if (spendLessThan.isEmpty()) {
            showToast("Please enter an amount to spend less than.")
            return
        }
        if (location.isEmpty()) {
            showToast("Please enter a location.")
            return
        }
        if (duration.isEmpty()) {
            showToast("Please enter a duration.")
            return
        }
        if (longTermGoal.isEmpty()) {
            showToast("Please specify your long-term goal.")
            return
        }

        // Convert spendLessThan to a numeric value
        val spendLessThanValue = spendLessThan.toDoubleOrNull()
        if (spendLessThanValue == null || spendLessThanValue <= 0) {
            showToast("Please enter a valid amount.")
            return
        }

        // If all validations pass, process the rule creation
        val ruleDetails = """
            Spend Less Than: $$spendLessThanValue
            At: $location
            Duration: $duration
            Toward: $longTermGoal
        """.trimIndent()

        // Display the rule details (for now, using a Toast)
        showToast("Rule Created:\n$ruleDetails")

        // Clear input fields after successful submission
        clearInputFields()
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    /**
     * Clears all input fields after successful submission.
     */
    private fun clearInputFields() {
        spendLessThanInput.text.clear()
        locationInput.text.clear()
        durationInput.text.clear()
        longTermGoalInput.text.clear()
    }
}