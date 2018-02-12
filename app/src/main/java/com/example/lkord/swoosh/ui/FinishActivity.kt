package com.example.lkord.swoosh.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lkord.swoosh.R
import com.example.lkord.swoosh.common.EXTRA_LEAGUE
import com.example.lkord.swoosh.common.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        searchingMatch.text = "Looking for $league $skill league near you"
    }

    companion object {
        fun getLaunchIntent(from: Context): Intent = Intent(from, FinishActivity::class.java)
    }
}
