package com.example.lkord.swoosh

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        next.setOnClickListener {
            startActivity(SkillActivity.getLaunchIntent(this))
        }
    }

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, LeagueActivity::class.java)
    }
}
