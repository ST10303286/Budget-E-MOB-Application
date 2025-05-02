package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Onboarding2Activity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        // Initialize UI elements
        buttonNext = findViewById(R.id.buttonNext)

        // Set up the button click listener
        buttonNext.setOnClickListener {
            navigateToNextScreen()
        }
    }

    /**
     * Navigates to the next onboarding screen.
     */
    private fun navigateToNextScreen() {
        val intent = Intent(this, Onboarding3Activity::class.java)
        startActivity(intent)
        finish() // Close the current activity to prevent returning to it via the back button
    }
}
