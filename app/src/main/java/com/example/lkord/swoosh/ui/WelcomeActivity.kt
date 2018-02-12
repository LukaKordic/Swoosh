package com.example.lkord.swoosh.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lkord.swoosh.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStarted.setOnClickListener {
            startActivity(LeagueActivity.getLaunchIntent(this))
        }
    }
}
