package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.budgete.teamapp.ConfirmationActivity

class ForgotPasswordActivity : AppCompatActivity() {

    // Declare UI elements as global variables
    private lateinit var emailField: EditText
    private lateinit var sendInstructionsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password) // Set the layout for this activity

        // Initialize UI elements
        emailField = findViewById(R.id.email_field)
        sendInstructionsButton = findViewById(R.id.send_instructions_button)

        // Set up the button click listener
        sendInstructionsButton.setOnClickListener {
            handleSendInstructions()
        }
    }

    /**
     * Handles the logic when the "Send Instructions" button is clicked.
     */
    private fun handleSendInstructions() {
        // Retrieve user input
        val email = emailField.text.toString().trim()

        // Validate email field
        if (email.isEmpty()) {
            showToast("Please enter your email address.")
            return
        }

        // Validate email format using a simple regex
        if (!isValidEmail(email)) {
            showToast("Please enter a valid email address.")
            return
        }

        // Simulate sending password reset instructions (for now, display a message)
        simulateSendingInstructions(email)

        // Optionally, navigate to a confirmation screen
        navigateToConfirmationScreen(email)
    }

    /**
     * Validates the email format using a simple regex.
     */
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
        return email.matches(emailPattern)
    }

    /**
     * Simulates sending password reset instructions.
     */
    private fun simulateSendingInstructions(email: String) {
        // Display a message indicating that instructions have been sent
        val message = "Password reset instructions have been sent to $email."
        showToast(message)
    }

    /**
     * Navigates to a confirmation screen (optional).
     */
    private fun navigateToConfirmationScreen(email: String) {
        // Create an Intent to navigate to a confirmation screen
        val intent = Intent(this, ConfirmationActivity::class.java)
        intent.putExtra("EMAIL", email) // Pass the email to the next activity
        startActivity(intent)

        // Optionally, finish this activity to prevent returning to it via the back button
        finish()
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
