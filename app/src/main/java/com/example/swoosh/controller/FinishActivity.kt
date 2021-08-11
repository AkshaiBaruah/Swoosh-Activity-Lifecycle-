package com.example.swoosh.controller


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh.R
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.utilities.EXTRA_SKILL


class FinishActivity : AppCompatActivity() {
    private lateinit var chosenleague : String
    private lateinit var skill : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        chosenleague= intent.getStringExtra(EXTRA_LEAGUE).toString()
        skill= intent.getStringExtra(EXTRA_SKILL).toString()
        val searchLeagueText :TextView = findViewById(R.id.searchLeagueText)
        searchLeagueText.text = "Looking for $chosenleague $skill league near you..."



    }
}