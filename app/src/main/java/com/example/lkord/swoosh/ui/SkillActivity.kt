package com.example.lkord.swoosh.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.lkord.swoosh.R
import com.example.lkord.swoosh.common.PLAYER_EXTRA
import com.example.lkord.swoosh.common.SELECT_SKILL
import com.example.lkord.swoosh.models.Player
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_skill)
        player = intent.getSerializableExtra(PLAYER_EXTRA) as Player

        beginner.setOnClickListener {
            baller.isChecked = false
            player.skill = beginner.textOn as String
        }

        baller.setOnClickListener {
            beginner.isChecked = false
            player.skill = baller.textOn as String
        }

        findGame.setOnClickListener {
            if (player.skill != "") {
                startActivity(FinishActivity.getLaunchIntent(this).putExtra(PLAYER_EXTRA, player))
            } else {
                Toast.makeText(this, SELECT_SKILL, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun getLaunchIntent(from: Context): Intent = Intent(from, SkillActivity::class.java)
    }
}
