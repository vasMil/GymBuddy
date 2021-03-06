package com.example.myapplication.boundaries

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class FindWorkoutPlanBoundary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.find_workout_plan_boundary)
        supportActionBar?.apply {
            title = "Find a workout plan"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }

        // Select the buttons on the view
        val createWorkoutPlan = findViewById<Button>(R.id.create_workout_plan)

        // TODO: Won't be implemented
        val findWorkoutPlan = findViewById<Button>(R.id.select_workout_plan)

        // Add event listeners
        createWorkoutPlan.setOnClickListener {
            val intentCreateWorkoutPlan = Intent(this,
                CreateWorkoutPlanBoundary::class.java)
            startActivity(intentCreateWorkoutPlan)
        }
    }

}