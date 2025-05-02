package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CongratsActivity : AppCompatActivity() {

    // Declare UI elements as global variables
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats) // Set the layout for this activity

        // Initialize UI elements
        buttonNext = findViewById(R.id.buttonNext)

        // Set up the button click listener
        buttonNext.setOnClickListener {
            handleNextButtonClick()
        }
    }

    /**
     * Handles the logic when the "Next" button is clicked.
     */
    private fun handleNextButtonClick() {
        // For now, display a simple message
        showToast("Navigating to the next screen...")

        // Example: Navigate to another activity (e.g., MainActivity)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        // Optionally, finish this activity to prevent returning to it via the back button
        finish()
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
