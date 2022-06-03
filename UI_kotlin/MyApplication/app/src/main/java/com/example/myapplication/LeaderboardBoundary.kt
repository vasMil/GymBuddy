package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.Serializable

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
        val regAttBtn = findViewById<Button>(R.id.register_attempt)
        regAttBtn.setOnClickListener {
            val intent = Intent(this,RegisterAttemptBoundary::class.java)
            startActivity(intent)
        }
    }





}
