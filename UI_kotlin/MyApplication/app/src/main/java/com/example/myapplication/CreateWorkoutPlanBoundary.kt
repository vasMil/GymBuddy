package com.example.myapplication

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
        val weigth = findViewById<EditText>(R.id.editText_weight)?.text
        val height = findViewById<EditText>(R.id.editText_height)?.text
        val days = findViewById<EditText>(R.id.editText_daysPerWeek)?.text

    }
}