package com.budgete.teamapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyAccountActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var fullNameField: EditText
    private lateinit var emailField: EditText
    private lateinit var phoneNumberField: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        // Initialize UI elements
        fullNameField = findViewById(R.id.full_name_field)
        emailField = findViewById(R.id.email_field)
        phoneNumberField = findViewById(R.id.phone_number_field)
        saveButton = findViewById(R.id.save_button)

        // Set up the button click listener
        saveButton.setOnClickListener {
            handleSaveChanges()
        }
    }

    /**
     * Handles the logic when the "Save Changes" button is clicked.
     */
    private fun handleSaveChanges() {
        // Retrieve user input
        val fullName = fullNameField.text.toString().trim()
        val email = emailField.text.toString().trim()
        val phoneNumber = phoneNumberField.text.toString().trim()

        // Validate input fields
        if (fullName.isEmpty()) {
            showToast("Please enter your full name.")
            return
        }

        if (email.isEmpty()) {
            showToast("Please enter your email address.")
            return
        }

        if (!isValidEmail(email)) {
            showToast("Please enter a valid email address.")
            return
        }

        if (phoneNumber.isEmpty()) {
            showToast("Please enter your phone number.")
            return
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            showToast("Please enter a valid phone number.")
            return
        }

        // Simulate saving changes (replace with actual backend logic if needed)
        simulateSaveChanges(fullName, email, phoneNumber)
    }

    /**
     * Validates the email format using a simple regex.
     */
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
        return email.matches(emailPattern)
    }

    /**
     * Validates the phone number format using a simple regex.
     */
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phonePattern = "\\d{10}".toRegex() // Example: 10-digit phone number
        return phonePattern.matches(phoneNumber)
    }

    /**
     * Simulates saving changes to the user's profile.
     */
    private fun simulateSaveChanges(fullName: String, email: String, phoneNumber: String) {
        // For now, display a success message
        val message = """
            Profile Updated:
            Full Name: $fullName
            Email: $email
            Phone Number: $phoneNumber
        """.trimIndent()

        showToast(message)
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}