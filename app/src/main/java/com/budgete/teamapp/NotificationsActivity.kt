package com.budgete.teamapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NotificationsActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var pushNotificationsCheckbox: CheckBox
    private lateinit var emailNotificationsCheckbox: CheckBox
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        // Initialize UI elements
        pushNotificationsCheckbox = findViewById(R.id.pushNotificationsCheckbox)
        emailNotificationsCheckbox = findViewById(R.id.emailNotificationsCheckbox)
        saveButton = findViewById(R.id.saveButton)

        // Set up the button click listener
        saveButton.setOnClickListener {
            handleSaveChanges()
        }
    }

    /**
     * Handles saving the notification preferences.
     */
    private fun handleSaveChanges() {
        val pushNotificationsEnabled = pushNotificationsCheckbox.isChecked
        val emailNotificationsEnabled = emailNotificationsCheckbox.isChecked

        // Simulate saving changes (replace with actual backend logic if needed)
        val message = """
            Notification Preferences Updated:
            Push Notifications: ${if (pushNotificationsEnabled) "Enabled" else "Disabled"}
            Email Notifications: ${if (emailNotificationsEnabled) "Enabled" else "Disabled"}
        """.trimIndent()

        showToast(message)
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}