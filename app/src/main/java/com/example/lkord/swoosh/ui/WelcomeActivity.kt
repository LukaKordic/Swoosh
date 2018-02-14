package com.example.lkord.swoosh.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.lkord.swoosh.R
import kotlinx.android.synthetic.main.activity_welcome.*

fun View.onClick(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStarted.onClick { startActivity(LeagueActivity.getLaunchIntent(this)) }
    }
}




