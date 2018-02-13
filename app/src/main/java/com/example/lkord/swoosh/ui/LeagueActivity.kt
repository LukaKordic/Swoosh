package com.example.lkord.swoosh.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.lkord.swoosh.R
import com.example.lkord.swoosh.common.PLAYER_EXTRA
import com.example.lkord.swoosh.common.SELECT_LEAGUE
import com.example.lkord.swoosh.models.Player
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    private var player = Player()

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable(PLAYER_EXTRA, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getSerializable(PLAYER_EXTRA) as Player
        }
        setContentView(R.layout.activity_league)

        menLeague.setOnClickListener {
            womenLeague.isChecked = false
            coedLeague.isChecked = false
            player.league = menLeague.text as String
        }

        womenLeague.setOnClickListener {
            menLeague.isChecked = false
            coedLeague.isChecked = false
            player.league = womenLeague.text as String
        }


        coedLeague.setOnClickListener {
            menLeague.isChecked = false
            womenLeague.isChecked = false
            player.league = coedLeague.text as String
        }

        next.setOnClickListener {
            if (player.league != "") {
                startActivity(SkillActivity.getLaunchIntent(this).putExtra(PLAYER_EXTRA, player))
            } else {
                Toast.makeText(this, SELECT_LEAGUE, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, LeagueActivity::class.java)
    }
}
