package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.utilities.EXTRA_SKILL

class SkillActivity : AppCompatActivity() {
    lateinit var chosenleague : String
    lateinit var skill : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        chosenleague = intent.getStringExtra(EXTRA_LEAGUE).toString()             //getting the passed extra from the previous activity

        val beginnerBtn : ToggleButton = findViewById(R.id.beginnerBtn)
        val ballerBtn : ToggleButton = findViewById(R.id.ballerBtn)
        val finishBtn : Button = findViewById(R.id.finishBtn)

        beginnerBtn.setOnClickListener {
            ballerBtn.isChecked = false
            skill = "beginner"
        }

        ballerBtn.setOnClickListener {
            beginnerBtn.isChecked = false
            skill = "baller"
        }

        finishBtn.setOnClickListener {
            if (ballerBtn.isChecked || beginnerBtn.isChecked) {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_LEAGUE, chosenleague )
                finishActivity.putExtra(EXTRA_SKILL, skill)
                startActivity(finishActivity)
            }
            else{
                Toast.makeText(this , "Please select a skill level!" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}