package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var forgotPasswordText: TextView
    private lateinit var loginButton: Button
    private lateinit var signUpText: TextView
    private lateinit var googleLogin: ImageView
    private lateinit var facebookLogin: ImageView
    private lateinit var appleLogin: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize UI elements
        emailField = findViewById(R.id.email_field)
        passwordField = findViewById(R.id.password_field)
        forgotPasswordText = findViewById(R.id.forgot_password_text)
        loginButton = findViewById(R.id.login_button)
        signUpText = findViewById(R.id.sign_up_text)
        googleLogin = findViewById(R.id.google_login)
        facebookLogin = findViewById(R.id.facebook_login)
        appleLogin = findViewById(R.id.apple_login)

        // Set up click listeners
        loginButton.setOnClickListener {
            handleLogin()
        }

        forgotPasswordText.setOnClickListener {
            navigateToForgotPassword()
        }

        signUpText.setOnClickListener {
            navigateToSignUp()
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
     * Handles the login process.
     */
    private fun handleLogin() {
        val email = emailField.text.toString().trim()
        val password = passwordField.text.toString().trim()

        // Validate input fields
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

        // Simulate successful login
        simulateLogin(email, password)
    }

    /**
     * Validates the email format using a simple regex.
     */
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
        return email.matches(emailPattern)
    }

    /**
     * Simulates the login process.
     */
    private fun simulateLogin(email: String, password: String) {
        // For now, display a success message and navigate to the home screen
        showToast("Logged in successfully as $email")
        navigateToHomeScreen()
    }

    /**
     * Navigates to the Forgot Password screen.
     */
    private fun navigateToForgotPassword() {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navigates to the Sign Up screen.
     */
    private fun navigateToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    /**
     * Handles social login.
     */
    private fun handleSocialLogin(provider: String) {
        // Simulate social login for now
        showToast("Logging in with $provider...")
        navigateToHomeScreen()
    }

    /**
     * Navigates to the Home screen.
     */
    private fun navigateToHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Close the login activity
    }

    /**
     * Displays a Toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
