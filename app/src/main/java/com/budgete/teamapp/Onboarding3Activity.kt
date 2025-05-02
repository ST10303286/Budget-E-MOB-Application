package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Onboarding3Activity : AppCompatActivity() {

    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        buttonNext = findViewById(R.id.buttonNext)

        buttonNext.setOnClickListener {
            navigateToNextScreen()
        }
    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}
