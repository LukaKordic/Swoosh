package com.example.lkord.swoosh.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lkord.swoosh.R
import com.example.lkord.swoosh.common.PLAYER_EXTRA
import com.example.lkord.swoosh.models.Player
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_finish)

        player = intent.getSerializableExtra(PLAYER_EXTRA) as Player

        searchingMatch.text = getString(R.string.looking_for_league, player.league, player.skill)
    }

    companion object {
        fun getLaunchIntent(from: Context): Intent = Intent(from, FinishActivity::class.java)
    }
}
