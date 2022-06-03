package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WorkoutPageBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout_choose)
        supportActionBar?.apply {
            title = "Workout Program"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }

    }
}