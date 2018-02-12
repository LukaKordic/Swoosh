package com.example.lkord.swoosh.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.lkord.swoosh.R
import com.example.lkord.swoosh.common.EXTRA_LEAGUE
import com.example.lkord.swoosh.common.EXTRA_SKILL
import com.example.lkord.swoosh.common.SELECT_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    var skillLevel = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        var league = intent.getStringExtra(EXTRA_LEAGUE)

        beginner.setOnClickListener {
            baller.isChecked = false
            skillLevel = beginner.textOn as String
        }

        baller.setOnClickListener {
            beginner.isChecked = false
            skillLevel = baller.textOn as String
        }

        findGame.setOnClickListener {
            if (skillLevel != "") {
                startActivity(FinishActivity.getLaunchIntent(this).putExtra(EXTRA_SKILL, skillLevel).putExtra(EXTRA_LEAGUE, league))
            } else {
                Toast.makeText(this, SELECT_SKILL, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun getLaunchIntent(from: Context): Intent = Intent(from, SkillActivity::class.java)
    }
}
