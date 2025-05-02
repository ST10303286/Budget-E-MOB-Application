package com.budgete.teamapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RuleDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rule_details)

        // Retrieve the rule type passed via Intent
        val ruleType = intent.getStringExtra("RULE_TYPE")

        // Display the rule type (example)
        val ruleTextView = findViewById<TextView>(R.id.ruleTextView)
        ruleTextView.text = "Rule: $ruleType"
    }
}