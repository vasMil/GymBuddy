package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class LeaderboardBoundary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_leaderboard_boundary)
        supportActionBar?.apply {
            title = "Leaderboard"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color))
            )
        }
        val exercise = intent.getSerializableExtra("exercise") as Exercise
        val titleView = findViewById<TextView>(R.id.leaderboard_title_exercise)
        titleView.text = exercise.name

    }
}