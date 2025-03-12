package com.example.smt4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.smt4.databinding.ActivityKabaddiBinding

class KabaddiActivity : AppCompatActivity() {
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding : ActivityKabaddiBinding = DataBindingUtil.setContentView(this, R.layout.activity_kabaddi)

        binding.scoreViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.apply {
            scoreTeamA.observe(this@KabaddiActivity) { scoreA ->
                if (scoreA >= 25) {
                    Toast.makeText(this@KabaddiActivity, "Tim A Menang!", Toast.LENGTH_LONG).show()
                    resetScore()
                }
            }
            
            scoreTeamB.observe(this@KabaddiActivity) { scoreB ->
                if (scoreB >= 25) {
                    Toast.makeText(this@KabaddiActivity, "Tim B Menang!", Toast.LENGTH_LONG).show()
                    resetScore()
                }
            }
        }

        // Team A buttons
        binding.buttonplus1A.setOnClickListener {
            viewModel.addScoreTeamA(1)
        }
        binding.buttonplus2A.setOnClickListener {
            viewModel.addScoreTeamA(2)
        }

        // Team B buttons
        binding.buttonplus1B.setOnClickListener {
            viewModel.addScoreTeamB(1)
        }
        binding.buttonplus2B.setOnClickListener {
            viewModel.addScoreTeamB(2)
        }

        // Reset button
        binding.buttonreset.setOnClickListener {
            viewModel.resetScore()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}