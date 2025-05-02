package com.budgete.teamapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GoalDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal_details)

        // Retrieve the goal type passed via Intent
        val goalType = intent.getStringExtra("GOAL_TYPE")

        // Display the goal type (example)
        val goalTextView = findViewById<TextView>(R.id.goalTextView)
        goalTextView.text = "Goal: $goalType"
    }
}