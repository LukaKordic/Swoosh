package com.example.lkord.swoosh

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SkillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
    }

    companion object {
        fun getLaunchIntent(from: Context): Intent = Intent(from, SkillActivity::class.java)
    }
}
