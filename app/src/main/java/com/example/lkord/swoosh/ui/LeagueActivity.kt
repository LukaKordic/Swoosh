package com.example.lkord.swoosh.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.lkord.swoosh.R
import com.example.lkord.swoosh.common.EXTRA_LEAGUE
import com.example.lkord.swoosh.common.SELECT_LEAGUE
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        menLeague.setOnClickListener {
            womenLeague.isChecked = false
            coedLeague.isChecked = false
            selectedLeague = menLeague.text as String
        }

        womenLeague.setOnClickListener {
            menLeague.isChecked = false
            coedLeague.isChecked = false
            selectedLeague = womenLeague.text as String
        }


        coedLeague.setOnClickListener {
            menLeague.isChecked = false
            womenLeague.isChecked = false
            selectedLeague = coedLeague.text as String
        }

        next.setOnClickListener {
            if (selectedLeague != "") {
                startActivity(SkillActivity.getLaunchIntent(this).putExtra(EXTRA_LEAGUE, selectedLeague))
            } else {
                Toast.makeText(this, SELECT_LEAGUE, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, LeagueActivity::class.java)
    }
}
