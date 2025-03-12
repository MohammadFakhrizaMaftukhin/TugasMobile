package com.example.smt4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.smt4.databinding.ActivityKabaddiBinding

class KabaddiActivity : AppCompatActivity() {
//    private lateinit var scoreTextA: TextView
//    private lateinit var scoreTextB: TextView
    private val viewModel: ScoreViewModel by viewModels()
//    private lateinit var binding: ActivityKabaddiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_kabaddi)

        val binding : ActivityKabaddiBinding = DataBindingUtil.setContentView(this, R.layout.activity_kabaddi)

        // Initialize TextViews
//        scoreTextA = findViewById(R.id.textscoreA)
//        scoreTextB = findViewById(R.id.textscoreB)

        // Observe score changes
//        val observerScoreA = Observer<Int>{ skorBaru ->
//            binding.textscoreA.text = skorBaru.toString()
//        }
//        viewModel.scoreTeamA.observe(this@KabaddiActivity, observerScoreA)
//        val observerScoreB = Observer<Int>{ skorBaru ->
//            binding.textscoreB.text = skorBaru.toString()
//        }
//        viewModel.scoreTeamB.observe(this@KabaddiActivity, observerScoreB)

        binding.scoreViewModel = viewModel
        binding.lifecycleOwner = this

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
//            ScoreViewModel.scoreTeamA.removeObserver(observerScoreA)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}