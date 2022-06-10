package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CreateWorkoutPlanBoundary : AppCompatActivity() {
    lateinit var beginnerBtn: Button;
    lateinit var intermediateBtn: Button;
    lateinit var advancedBtn: Button;
    var btnIdClicked: Int? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            title = "Create Workout Plan"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        setContentView(R.layout.create_workout_plan)

        beginnerBtn = findViewById(R.id.button_beginner)
        intermediateBtn = findViewById(R.id.button_intermediate)
        advancedBtn = findViewById(R.id.button_advanced)

        beginnerBtn.setOnClickListener {
            onUserLevelClick(it)
        }
        intermediateBtn.setOnClickListener {
            onUserLevelClick(it)
        }
        advancedBtn.setOnClickListener {
            onUserLevelClick(it)
        }

        val continueBtn = findViewById<Button>(R.id.workoutPlan_continue)
        continueBtn.setOnClickListener {
            onContinue()
        }

    }

    private fun onUserLevelClick(btn: View) {
        btn.setBackgroundColor(Color.parseColor("#8f6147"))
        when (btn) {
            beginnerBtn -> {
                btnIdClicked = beginnerBtn.id
                intermediateBtn.setBackgroundColor(Color.parseColor("#F16D22"))
                advancedBtn.setBackgroundColor(Color.parseColor("#F16D22"))
            }
            intermediateBtn -> {
                btnIdClicked = intermediateBtn.id
                beginnerBtn.setBackgroundColor(Color.parseColor("#F16D22"))
                advancedBtn.setBackgroundColor(Color.parseColor("#F16D22"))
            }
            else -> {
                btnIdClicked = advancedBtn.id
                beginnerBtn.setBackgroundColor(Color.parseColor("#F16D22"))
                intermediateBtn.setBackgroundColor(Color.parseColor("#F16D22"))
            }
        }
    }

    private fun onContinue() {
        if (btnIdClicked == null) {
            Toast.makeText(this@CreateWorkoutPlanBoundary,
                "You must select the level of the athlete!", Toast.LENGTH_SHORT).show()
            return
        }
        val weight = findViewById<EditText>(R.id.editText_weight).text
        val height = findViewById<EditText>(R.id.editText_height).text
        val days = findViewById<EditText>(R.id.editText_daysPerWeek).text
        if (weight.isEmpty() || height.isEmpty() || days.isEmpty()) {
            Toast.makeText(
                this@CreateWorkoutPlanBoundary,
                "Weight, height or days of workout is empty!", Toast.LENGTH_SHORT
            ).show()
            return
        }
        if(weight.toString().toInt() > 300 || weight.toString().toInt() <= 0) {
            Toast.makeText(
                this@CreateWorkoutPlanBoundary,
                "Weight is invalid!", Toast.LENGTH_SHORT
            ).show()
            return
        }
        if(height.toString().toInt() > 350 || height.toString().toInt() <= 0) {
            Toast.makeText(
                this@CreateWorkoutPlanBoundary,
                "Height is invalid!", Toast.LENGTH_SHORT
            ).show()
            return
        }
        if(days.toString().toInt() > 7 || days.toString().toInt() <= 0) {
            Toast.makeText(
                this@CreateWorkoutPlanBoundary,
                "Days of workout is invalid!", Toast.LENGTH_SHORT
            ).show()
            return
        }

        // All values are acceptable - allow use case to progress
        val minUserLevel = when (btnIdClicked) {
            beginnerBtn.id -> UserLevel.BEGINNER
            intermediateBtn.id -> UserLevel.INTERMEDIATE
            else -> UserLevel.ADVANCED
        }
        // Get the builder initialized
        WorkoutPlanBuilder.initWorkoutPlan(days.toString().toInt(), weight.toString().toInt(),
            height.toString().toInt(), "Custom Workout Plan", 123, minUserLevel)
        val intentSetupDay = Intent(this, SetupDayOfWorkoutBoundary::class.java)
        startActivity(intentSetupDay)
    }
}