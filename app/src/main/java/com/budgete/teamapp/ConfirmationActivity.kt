package com.budgete.teamapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation) // Set the layout for this activity

        // Retrieve the email passed from ForgotPasswordActivity
        val email = intent.getStringExtra("EMAIL")

        // Display the email on the confirmation screen
        val confirmationTextView = findViewById<TextView>(R.id.confirmationTextView)
        confirmationTextView.text = "Password reset instructions have been sent to $email."
    }
}