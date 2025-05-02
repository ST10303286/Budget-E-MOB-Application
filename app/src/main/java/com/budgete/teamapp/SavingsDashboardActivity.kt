package com.budgete.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SavingsDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings_dashboard)

        val createNowLink = findViewById<TextView>(R.id.createNowLink)
        createNowLink.setOnClickListener {
            startActivity(Intent(this, CreateRuleActivity::class.java))
        }

    }
}
