package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.swoosh.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating button object for get started button

        val getStartedBtn : Button = findViewById(R.id.getStartedBtn)

        //using the onclicklistener method on getstartedBtn object

        getStartedBtn.setOnClickListener {
            val leagueIntent = Intent(this , LeagueActivity::class.java)
            startActivity(leagueIntent)
        }

    }
}