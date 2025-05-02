package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var fullNameField: EditText
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInText: TextView
    private lateinit var googleLogin: ImageView
    private lateinit var facebookLogin: ImageView
    private lateinit var appleLogin: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize UI elements
        fullNameField = findViewById(R.id.full_name_field)
        emailField = findViewById(R.id.email_field)
        passwordField = findViewById(R.id.password_field)
        confirmPasswordField = findViewById(R.id.confirm_password_field)
        signUpButton = findViewById(R.id.signup_button)
        signInText = findViewById(R.id.sign_in_text)
        googleLogin = findViewById(R.id.google_login)
        facebookLogin = findViewById(R.id.facebook_login)
        appleLogin = findViewById(R.id.apple_login)

        // Set up click listeners
        signUpButton.setOnClickListener {
            handleSignUp()
        }

        signInText.setOnClickListener {
            navigateToSignIn()
        }

        googleLogin.setOnClickListener {
            handleSocialLogin("Google")
        }

        facebookLogin.setOnClickListener {
            handleSocialLogin("Facebook")
        }

        appleLogin.setOnClickListener {
            handleSocialLogin("Apple")
        }
    }

    /**
     * Handles the sign-up process.
     */
    private fun handleSignUp() {
        val fullName = fullNameField.text.toString().trim()
        val email = emailField.text.toString().trim()
        val password = passwordField.text.toString().trim()
        val confirmPassword = confirmPasswordField.text.toString().trim()

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

        if (password.isEmpty()) {
            showToast("Please enter your password.")
            return
        }

        if (password.length < 6) {
            showToast("Password must be at least 6 characters long.")
            return
        }

        if (confirmPassword.isEmpty()) {
            showToast("Please confirm your password.")
            return
        }

        if (password != confirmPassword) {
            showToast("Passwords do not match.")
            return
        }

        // Simulate successful sign-up
        simulateSignUp(fullName, email, password)
    }

    /**
     * Validates the email format using a simple regex.
     */
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
        return email.matches(emailPattern)
    }

    /**
     * Simulates the sign-up process.
     */
    private fun simulateSignUp(fullName: String, email: String, password: String) {
        // For now, display a success message and navigate to the home screen
        showToast("Account created successfully for $fullName ($email)")
        navigateToHomeScreen()
    }

    /**
     * Navigates to the Sign In screen.
     */
    private fun navigateToSignIn() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Close the sign-up activity
    }

    /**
     * Handles social login.
     */
    private fun handleSocialLogin(provider: String) {
        // Simulate social login for now
        showToast("Signing up with $provider...")
        navigateToHomeScreen()
    }

    /**
     * Navigates to the Home screen.
     */
    private fun navigateToHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Close the sign-up activity
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
