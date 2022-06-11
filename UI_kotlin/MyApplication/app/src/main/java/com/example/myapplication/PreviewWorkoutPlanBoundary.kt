package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class PreviewWorkoutPlanBoundary : AppCompatActivity() {
    private val workoutPlan = UserSession.getUser<Athlete>().workoutPlan
    private lateinit var workoutPlanPreview: LinearLayout
    private lateinit var workoutDayPreview: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preview_workout_plan_boundary)
        supportActionBar?.apply {
            title = "Preview Workout Plan"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        workoutPlanPreview = findViewById(R.id.workoutPlan)
        workoutDayPreview = findViewById(R.id.workoutDay)
        displayWorkoutPlanDays()

        val backToHome = findViewById<Button>(R.id.backToHome)
        backToHome.setOnClickListener {
            startActivity(Intent(this, HomePageBoundary::class.java))
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun displayWorkoutPlanDays() {
        workoutPlan!!.workoutDays.forEach {
            createWorkoutDayButton(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun createWorkoutDayButton(workoutDay: WorkoutDay) {
        val btn = Button(this)
        btn.text = workoutDay.name
        btn.width = LinearLayout.LayoutParams.WRAP_CONTENT
        btn.height = LinearLayout.LayoutParams.WRAP_CONTENT
        btn.isAllCaps = false
        btn.textSize = 15f
        btn.setOnClickListener {
            previewWorkoutDay(workoutDay)
        }
        workoutPlanPreview.addView(btn)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun previewWorkoutDay(workoutDay: WorkoutDay) {
        workoutDayPreview.removeAllViews()
        workoutDay.exercises.forEach { exercise ->
            val exerciseTextView = TextView(this)
            exerciseTextView.text = exercise.name
            exerciseTextView.textSize = 17f
            exerciseTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            workoutDayPreview.addView(exerciseTextView)
        }
    }
}