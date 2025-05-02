package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileSettingsActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var buttonMyAccount: Button
    private lateinit var buttonHelpCenter: Button
    private lateinit var buttonSettings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        // Initialize UI elements
        buttonMyAccount = findViewById(R.id.buttonMyAccount)
        buttonHelpCenter = findViewById(R.id.buttonHelpCenter)
        buttonSettings = findViewById(R.id.buttonSettings)

        // Set up click listeners for the buttons
        buttonMyAccount.setOnClickListener {
            navigateToMyAccount()
        }

        buttonHelpCenter.setOnClickListener {
            navigateToHelpCenter()
        }

        buttonSettings.setOnClickListener {
            navigateToSettings()
        }
    }

    /**
     * Navigates to the My Account screen.
     */
    private fun navigateToMyAccount() {
        val intent = Intent(this, MyAccountActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navigates to the Help Center screen.
     */
    private fun navigateToHelpCenter() {
        val intent = Intent(this, HelpCenterActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navigates to the Settings screen.
     */
    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}