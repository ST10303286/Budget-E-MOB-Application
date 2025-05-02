package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResetPasswordActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var newPasswordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var resetPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        // Initialize UI elements
        newPasswordField = findViewById(R.id.new_password_field)
        confirmPasswordField = findViewById(R.id.confirm_password_field)
        resetPasswordButton = findViewById(R.id.reset_password_button)

        // Set up the button click listener
        resetPasswordButton.setOnClickListener {
            handleResetPassword()
        }
    }

    /**
     * Handles the logic when the "Reset Password" button is clicked.
     */
    private fun handleResetPassword() {
        // Retrieve user input
        val newPassword = newPasswordField.text.toString().trim()
        val confirmPassword = confirmPasswordField.text.toString().trim()

        // Validate input fields
        if (newPassword.isEmpty()) {
            showToast("Please enter your new password.")
            return
        }

        if (newPassword.length < 6) {
            showToast("Password must be at least 6 characters long.")
            return
        }

        if (confirmPassword.isEmpty()) {
            showToast("Please confirm your new password.")
            return
        }

        if (newPassword != confirmPassword) {
            showToast("Passwords do not match.")
            return
        }

        // Simulate resetting the password (replace with actual backend logic if needed)
        simulateResetPassword(newPassword)
    }

    /**
     * Simulates resetting the password.
     */
    private fun simulateResetPassword(newPassword: String) {
        // For now, display a success message
        showToast("Password reset successfully. New password: $newPassword")
        navigateToLoginScreen()
    }

    /**
     * Navigates to the Login screen after resetting the password.
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