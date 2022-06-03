package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.core.widget.NestedScrollView
import java.io.Serializable

class ChooseExerciseBoundary : AppCompatActivity() {
    private lateinit var exercises: Array<Exercise>
    private var exerciseIndex = 0;
    private lateinit var category: ExerciseCategory

    init {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_exercise_boundary)


        this.category = intent.getSerializableExtra("category") as ExerciseCategory
        displayExercises()
    }

    private fun displayExercises() {
        // fetch the exercises
        category.fetchExercises()
        exercises = category.exercises.toTypedArray()
        // display buttons
        val exercisesView = findViewById<LinearLayout>(R.id.exerciseScrollView)
        exercises.forEach {
            createExerciseButton(exercisesView, it)
        }
    }

    private fun createExerciseButton(layout: LinearLayout, exercise: Exercise): Button {
        val btn = Button(this)
        btn.text = exercise.name
        btn.tag = exercise.name.lowercase() + "_" + exerciseIndex
        btn.width = LinearLayout.LayoutParams.WRAP_CONTENT
        btn.height = LinearLayout.LayoutParams.WRAP_CONTENT

        btn.setTextColor(Color.parseColor("#F16D22"))
        layout.addView(btn)
        btn.setOnClickListener {
            val intent = Intent(this, LeaderboardBoundary::class.java)
            intent.putExtra("exercise", exercise as Serializable)
            startActivity(intent)
        }


        return btn
    }



}