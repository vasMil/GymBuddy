package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChooseExerciseBoundary : AppCompatActivity() {
    private lateinit var exercises: Array<Exercise>
    private var exerciseIndex = 0
    private lateinit var category: ExerciseCategory
    private lateinit var confirmButton: Button
    private lateinit var acceptSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_exercise_boundary)
        supportActionBar?.apply {
            title = "Upload Video"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }

        this.category = intent.getSerializableExtra("category") as ExerciseCategory
        displayExercises()

        confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.visibility = View.GONE
        acceptSwitch = findViewById<Switch>(R.id.acceptSwitch)
        acceptSwitch.visibility = View.GONE
    }

    private fun displayExercises() {
        // fetch the exercises
        category.fetchExercises()
        exercises = category.exercises.toTypedArray()
        // display buttons
        val exercisesView = findViewById<LinearLayout>(R.id.exerciseScrollView)
        exercises.forEach { it ->
            val btn = createExerciseButton(exercisesView, it)
            btn.setOnClickListener { itBtn ->
                // TODO: Pass control to "upload a file" use case
                // Update confirmation button for the upload and display it
                displayConfirmButton(itBtn.tag.toString().split("_")[1].toInt())
                confirmButton.setOnClickListener {
                    handleConfirmation()
                }
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

    private fun displayConfirmButton(exerciseInd: Int) {
        confirmButton.text = getString(R.string.uv_confirm_upload, exercises[exerciseInd].name)
        confirmButton.tag = "confirm_$exerciseInd"
        confirmButton.visibility = View.VISIBLE
        acceptSwitch.visibility = View.VISIBLE
    }

    private fun handleConfirmation() {
        if(acceptSwitch.isChecked) {
            Toast.makeText(this@ChooseExerciseBoundary, "Success!",
                Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this@ChooseExerciseBoundary, "Failed to upload video!",
                Toast.LENGTH_SHORT)
                .show()
        }
    }
}