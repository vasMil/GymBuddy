package com.example.myapplication.boundaries

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.entities.Exercise
import com.example.myapplication.R

class LeaderboardBoundary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_leaderboard_boundary)
        supportActionBar?.apply {
            title = "Leaderboard"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color))
            )
        }
        var exercise = intent.getSerializableExtra("exercise")
        if (exercise == null) {
            Toast.makeText(this@LeaderboardBoundary, "You have a pending attempt", Toast.LENGTH_SHORT).show()
        }
        else {
            exercise = exercise as Exercise
            val titleView = findViewById<TextView>(R.id.leaderboard_title_exercise)
            titleView.text = exercise.name
            val regAttBtn = findViewById<Button>(R.id.register_attempt)
            regAttBtn.setOnClickListener {
                val intent = Intent(this, RegisterAttemptBoundary::class.java)
                startActivity(intent)
            }
        }

    }





}
