package com.example.myapplication.boundaries

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class WorkoutPageBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout_choose)
        supportActionBar?.apply {
            title = "Your workout plan"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }

    }
}