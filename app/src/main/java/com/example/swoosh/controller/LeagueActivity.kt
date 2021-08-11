package com.example.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.R

class LeagueActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        lateinit var chosenLeague : String

        // Setting up button objects so that onclickListener method may be used to do specific tasks when clicked.

        val mensBtn : ToggleButton=findViewById(R.id.mensBtn)
        val womensBtn : ToggleButton=findViewById(R.id.womensBtn)
        val coedBtn : ToggleButton=findViewById(R.id.coedBtn)
        val desiredLeagueNxtBtn : Button = findViewById(R.id.desiredLeagueNxtBtn)

        // setting up onclickListener methods for each button to do tasks when clicked.

        mensBtn.setOnClickListener {
            womensBtn.isChecked = false
            coedBtn.isChecked = false
            chosenLeague = "mens"
        }
        womensBtn.setOnClickListener {
            mensBtn.isChecked = false
            coedBtn.isChecked = false
            chosenLeague = "womens"
        }
        coedBtn.setOnClickListener {
            womensBtn.isChecked = false
            mensBtn.isChecked = false
            chosenLeague = "co-ed"
        }
        desiredLeagueNxtBtn.setOnClickListener {

            //if any one or more button(s) is(are) checked only then move to next activity

            if(womensBtn.isChecked || mensBtn.isChecked || coedBtn.isChecked){
                val skillActivity = Intent(this, SkillActivity::class.java)
                skillActivity.putExtra(EXTRA_LEAGUE , chosenLeague)                          //way to pass things to next activity
                startActivity(skillActivity)
            }

            //if all three toggle buttons are unchecked then show this toast

            else{
                Toast.makeText(this ,"Please Select a League!" , Toast.LENGTH_SHORT ).show()
            }
        }

    }

    }



