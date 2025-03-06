package com.example.smt4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KabaddiActivity : AppCompatActivity() {
    private lateinit var scoreTextA: TextView
    private lateinit var scoreTextB: TextView
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kabaddi)
        
        // Initialize TextViews
        scoreTextA = findViewById(R.id.textscoreA)
        scoreTextB = findViewById(R.id.textscoreB)

        // Observe score changes
        viewModel.scoreTeamA.observe(this) { score ->
            scoreTextA.text = score.toString()
        }
        viewModel.scoreTeamB.observe(this) { score ->
            scoreTextB.text = score.toString()
        }

        // Team A buttons
        findViewById<Button>(R.id.buttonplus1A).setOnClickListener {
            viewModel.addScoreTeamA(1)
        }
        findViewById<Button>(R.id.buttonplus2A).setOnClickListener {
            viewModel.addScoreTeamA(2)
        }

        // Team B buttons
        findViewById<Button>(R.id.buttonplus1B).setOnClickListener {
            viewModel.addScoreTeamB(1)
        }
        findViewById<Button>(R.id.buttonplus2B).setOnClickListener {
            viewModel.addScoreTeamB(2)
        }

        // Reset button
        findViewById<Button>(R.id.buttonreset).setOnClickListener {
            viewModel.resetScore()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}