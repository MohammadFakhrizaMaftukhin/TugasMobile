package com.example.smt4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KabaddiActivity : AppCompatActivity() {
    private var scoreTeamA = 0
    private var scoreTeamB = 0
    private lateinit var scoreTextA: TextView
    private lateinit var scoreTextB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabaddi)

        // Initialize TextViews
        scoreTextA = findViewById(R.id.textscoreA)
        scoreTextB = findViewById(R.id.textscoreB)

        // Team A buttons
        findViewById<Button>(R.id.buttonplus1A).setOnClickListener {
            scoreTeamA += 1
            updateScore()
        }
        findViewById<Button>(R.id.buttonplus2A).setOnClickListener {
            scoreTeamA += 2
            updateScore()
        }

        // Team B buttons
        findViewById<Button>(R.id.buttonplus1B).setOnClickListener {
            scoreTeamB += 1
            updateScore()
        }
        findViewById<Button>(R.id.buttonplus2B).setOnClickListener {
            scoreTeamB += 2
            updateScore()
        }

        // Reset button
        findViewById<Button>(R.id.buttonreset).setOnClickListener {
            scoreTeamA = 0
            scoreTeamB = 0
            updateScore()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}