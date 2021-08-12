package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER


class SkillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        val player: Player? = intent.getParcelableExtra(EXTRA_PLAYER)            //getting the passed extra from the previous activity

        val beginnerBtn : ToggleButton = findViewById(R.id.beginnerBtn)
        val ballerBtn : ToggleButton = findViewById(R.id.ballerBtn)
        val finishBtn : Button = findViewById(R.id.finishBtn)

        beginnerBtn.setOnClickListener {
            ballerBtn.isChecked = false
            player?.skill = "beginner"
        }

        ballerBtn.setOnClickListener {
            beginnerBtn.isChecked = false
            player?.skill = "baller"
        }

        finishBtn.setOnClickListener {
            if (ballerBtn.isChecked || beginnerBtn.isChecked) {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_PLAYER , player)
                startActivity(finishActivity)
            }
            else{
                Toast.makeText(this , "Please select a skill level!" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}