package com.budgete.teamapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RewardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        val ticTacToeButton = findViewById<Button>(R.id.tic_tac_toe)
        val seeAllGamesText = findViewById<TextView>(R.id.seeAllText)

        // Disable click functionality temporarily
        ticTacToeButton.isEnabled = false
        seeAllGamesText.isEnabled = false
    }
}
