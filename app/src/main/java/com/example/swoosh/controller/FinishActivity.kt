package com.example.swoosh.controller


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val player : Player? = intent.getParcelableExtra(EXTRA_PLAYER)
        val searchLeagueText :TextView = findViewById(R.id.searchLeagueText)
        searchLeagueText.text = "Looking for ${player?.chosenLeague} ${player?.skill} league near you..."



    }
}