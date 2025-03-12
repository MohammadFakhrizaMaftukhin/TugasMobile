package com.example.smt4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreTeamA = MutableLiveData<Int>(0)
    private val _scoreTeamB = MutableLiveData<Int>(0)

    val scoreTeamA: LiveData<Int>
        get() = _scoreTeamA
    val scoreTeamB: LiveData<Int>
        get() = _scoreTeamB

    fun addScoreTeamA(points: Int) {
        _scoreTeamA.value = (_scoreTeamA.value ?: 0) + points
    }

    fun addScoreTeamB(points: Int) {
        _scoreTeamB.value = (_scoreTeamB.value ?: 0) + points
    }

    fun resetScore() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }
}