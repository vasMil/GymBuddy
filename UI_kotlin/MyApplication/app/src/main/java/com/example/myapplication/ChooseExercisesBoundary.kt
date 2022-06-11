package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class ChooseExercisesBoundary : AppCompatActivity() {
    // Get info from WorkoutPlanBuilder
    private var categories = WorkoutPlanBuilder.currentDayCategories
    private lateinit var exercises: Array<Exercise>
    private var selectedExercises: MutableList<Exercise> = mutableListOf()
    private lateinit var isSelected: Array<Boolean>
    private var exerciseIndex = 0
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_exercises_boundary)
        supportActionBar?.apply {
            title = "Choose Exercises"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }

        displayExercises()

        confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener {
            if(selectedExercises.size <= 0) {
                Toast.makeText(this@ChooseExercisesBoundary,
                    "You need to select at least one exercise!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Update workout plan builder
            WorkoutPlanBuilder.currentDaySelectedExercises = selectedExercises.toTypedArray()
            // Add the day to the WorkoutPlan
            WorkoutPlanBuilder.appendDay()

            // If the workout plan is complete move toast a message and move to the home page
            // else intent to the SetupDayOfWorkoutBoundary to configure next day
            if(WorkoutPlanBuilder.isComplete) {
                Toast.makeText(this@ChooseExercisesBoundary,
                    "Workout Plan is done!", Toast.LENGTH_LONG).show()
                WorkoutPlanBuilder.saveWorkoutPlan()
                startActivity(Intent(this, PreviewWorkoutPlanBoundary::class.java))
            }
            else {
                startActivity(Intent(this, SetupDayOfWorkoutBoundary::class.java))
            }
        }
    }

    private fun displayExercises() {
        val mutExercises = mutableListOf<Exercise>()
        for(category in categories) {
            // fetch the exercises
            category.fetchExercises()
            mutExercises.addAll(category.exercises)
        }
        exercises = mutExercises.toTypedArray()
        isSelected = Array<Boolean>(this.exercises.size) { _ -> false }

        // display buttons
        val exercisesView = findViewById<LinearLayout>(R.id.exerciseScrollView)
        exercises.forEach { it ->
            val btn = createExerciseButton(exercisesView, it)
            btn.setOnClickListener { itBtn ->
                handleSelect(itBtn)
            }
        }
    }

    private fun createExerciseButton(layout: LinearLayout, exercise: Exercise): Button {
        val btn = Button(this)
        btn.text = exercise.name
        btn.tag = exercise.name.lowercase() + "_" + exerciseIndex
        exerciseIndex++
        btn.width = LinearLayout.LayoutParams.WRAP_CONTENT
        btn.height = LinearLayout.LayoutParams.WRAP_CONTENT

        btn.setTextColor(Color.parseColor("#F16D22"))
        btn.isAllCaps = false
        btn.textSize = 15f
        layout.addView(btn)
        return btn
    }

    private fun handleSelect(btn: View) {
        val id = Integer.parseInt(btn.tag.toString().split("_")[1])
        // Check if btn is already selected
        if (isSelected[id]) {
            isSelected[id] = false
            selectedExercises.forEach {
                if (it == exercises[id]) {
                    selectedExercises.remove(it)
                    btn.alpha = 1f
                    return
                }
            }
        }
        isSelected[id] = true
        selectedExercises.add(exercises[id])
        btn.alpha = 0.5f
    }

    private fun displayConfirmButton(exerciseInd: Int) {
        confirmButton.text = getString(R.string.uv_confirm_upload, exercises[exerciseInd].name)
        confirmButton.tag = "confirm_$exerciseInd"
        confirmButton.visibility = View.VISIBLE
    }

}