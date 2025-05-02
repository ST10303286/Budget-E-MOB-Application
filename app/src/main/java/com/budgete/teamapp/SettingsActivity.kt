package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var resetPasswordText: TextView
    private lateinit var notificationsText: TextView
    private lateinit var privacyPolicyText: TextView
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize UI elements
        resetPasswordText = findViewById(R.id.resetPasswordText)
        notificationsText = findViewById(R.id.notificationsText)
        privacyPolicyText = findViewById(R.id.privacyPolicyText)
        logoutButton = findViewById(R.id.logoutButton)

        // Set up click listeners for settings options
        resetPasswordText.setOnClickListener {
            navigateToResetPassword()
        }

        notificationsText.setOnClickListener {
            navigateToNotifications()
        }

        privacyPolicyText.setOnClickListener {
            navigateToPrivacyPolicy()
        }

        // Set up the logout button click listener
        logoutButton.setOnClickListener {
            handleLogout()
        }
    }

    /**
     * Navigates to the Reset Password screen.
     */
    private fun navigateToResetPassword() {
        val intent = Intent(this, ResetPasswordActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navigates to the Notifications screen.
     */
    private fun navigateToNotifications() {
        val intent = Intent(this, NotificationsActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navigates to the Privacy Policy screen.
     */
    private fun navigateToPrivacyPolicy() {
        val intent = Intent(this, PrivacyPolicyActivity::class.java)
        startActivity(intent)
    }

    /**
     * Handles the logout process.
     */
    private fun handleLogout() {
        // Simulate logout (replace with actual logout logic if needed)
        showToast("Logged out successfully")
        navigateToLoginScreen()
    }

    /**
     * Navigates to the Login screen after logout.
     */
    private fun navigateToLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK // Clear back stack
        startActivity(intent)
        finish() // Close the current activity
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}