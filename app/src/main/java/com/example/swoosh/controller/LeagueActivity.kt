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

class LeagueActivity : AppCompatActivity() {

    private val player = Player("","")

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER , player)
    }
    "It was in lesson instance state but this app does not change orientation when rotated so the
    instance of the activity does not get destroyed." After this we had to override fun onRestoreInstantState.
    Here outState that is passed from above fun is received as parameter and we can call getParcelable
    method and assign it to player again using the EXTRA_PLAYER key.
    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)



        // Setting up button objects so that onclickListener method may be used to do specific tasks when clicked.

        val mensBtn : ToggleButton=findViewById(R.id.mensBtn)
        val womensBtn : ToggleButton=findViewById(R.id.womensBtn)
        val coedBtn : ToggleButton=findViewById(R.id.coedBtn)
        val desiredLeagueNxtBtn : Button = findViewById(R.id.desiredLeagueNxtBtn)

        // setting up onclickListener methods for each button to do tasks when clicked.

        mensBtn.setOnClickListener {
            womensBtn.isChecked = false
            coedBtn.isChecked = false
            player.chosenLeague = "mens"
        }
        womensBtn.setOnClickListener {
            mensBtn.isChecked = false
            coedBtn.isChecked = false
            player.chosenLeague = "womens"
        }
        coedBtn.setOnClickListener {
            womensBtn.isChecked = false
            mensBtn.isChecked = false
            player.chosenLeague = "co-ed"
        }
        desiredLeagueNxtBtn.setOnClickListener {

            //if any one or more button(s) is(are) checked only then move to next activity

            if(womensBtn.isChecked || mensBtn.isChecked || coedBtn.isChecked){
                val skillActivity = Intent(this, SkillActivity::class.java)
                skillActivity.putExtra(EXTRA_PLAYER,player)                       //way to pass things to next activity
                startActivity(skillActivity)
            }

            //if all three toggle buttons are unchecked then show this toast

            else{
                Toast.makeText(this ,"Please Select a League!" , Toast.LENGTH_SHORT ).show()
            }
        }

    }

    }



