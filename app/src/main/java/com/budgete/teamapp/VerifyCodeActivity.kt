package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VerifyCodeActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var codeBox1: EditText
    private lateinit var codeBox2: EditText
    private lateinit var codeBox3: EditText
    private lateinit var codeBox4: EditText
    private lateinit var verifyButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_code)

        // Initialize UI elements
        codeBox1 = findViewById(R.id.code_box_1)
        codeBox2 = findViewById(R.id.code_box_2)
        codeBox3 = findViewById(R.id.code_box_3)
        codeBox4 = findViewById(R.id.code_box_4)
        verifyButton = findViewById(R.id.verify_button)
        cancelButton = findViewById(R.id.cancel_button)

        // Set up OTP input listeners
        setupOtpInputListeners()

        // Set up button click listeners
        verifyButton.setOnClickListener {
            handleVerifyCode()
        }

        cancelButton.setOnClickListener {
            handleCancel()
        }
    }

    /**
     * Sets up listeners for OTP input fields to move focus automatically.
     */
    private fun setupOtpInputListeners() {
        val otpBoxes = listOf(codeBox1, codeBox2, codeBox3, codeBox4)

        otpBoxes.forEachIndexed { index, editText ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1 && index < otpBoxes.size - 1) {
                        otpBoxes[index + 1].requestFocus()
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }

    /**
     * Handles the verification of the OTP code.
     */
    private fun handleVerifyCode() {
        // Retrieve OTP digits
        val otp = "${codeBox1.text}${codeBox2.text}${codeBox3.text}${codeBox4.text}"

        // Validate OTP length
        if (otp.length != 4) {
            showToast("Please enter a valid 4-digit code.")
            return
        }

        // Simulate OTP verification (replace with actual backend logic if needed)
        simulateOtpVerification(otp)
    }

    /**
     * Simulates OTP verification.
     */
    private fun simulateOtpVerification(otp: String) {
        // For now, display a success message
        showToast("OTP verified successfully: $otp")
        navigateToNextScreen()
    }

    /**
     * Handles the cancel action.
     */
    private fun handleCancel() {
        showToast("Verification canceled.")
        finish() // Close the current activity
    }

    /**
     * Navigates to the next screen after successful OTP verification.
     */
    private fun navigateToNextScreen() {
        val intent = Intent(this, MainActivity::class.java) // Replace with the target activity
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