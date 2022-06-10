package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SetupDayOfWorkoutBoundary : AppCompatActivity() {
    private var dayIndex = WorkoutPlanBuilder.dayCount
    private var exerciseIndex = 0
    private var categories: Array<ExerciseCategory>
    private var selectedCategories: MutableList<ExerciseCategory> = mutableListOf()
    private lateinit var isSelected: Array<Boolean>

    init {
        val categoryService = CategoryService()
        categoryService.fetchCategories()
        categories = categoryService.categories.toTypedArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setup_day_of_workout_boundary)
        supportActionBar?.apply {
            title = "Setup day - $dayIndex"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        displayCategories()

        val doneBtn = findViewById<Button>(R.id.done_button)
        doneBtn.setOnClickListener {
            onDone()
        }
    }

    private fun onDone() {
        // Update Builder
        WorkoutPlanBuilder.currentDayCategories = selectedCategories.toTypedArray()

        // Check whether categories are selected
        if(selectedCategories.size <= 0) {
            Toast.makeText(this@SetupDayOfWorkoutBoundary,
                "You need to select at least one exercise category!",
                Toast.LENGTH_SHORT).show()
            return
        }

        // Check if a name is set
        val nameInp = findViewById<EditText>(R.id.dayNameInp)
        if(nameInp.text.isEmpty()) {
            Toast.makeText(this@SetupDayOfWorkoutBoundary,
                "You need to set a name for this workout day!",
                Toast.LENGTH_SHORT).show()
            return
        }
        // Update WorkoutPlanBuilder
        WorkoutPlanBuilder.currentDayName = nameInp.text.toString()
        // Intent to ChooseExercisesBoundary
        startActivity(Intent(this, ChooseExercisesBoundary::class.java))
    }

    private fun displayCategories() {
        val nestedView = findViewById<LinearLayout>(R.id.categories_nestedView)
        isSelected = Array<Boolean>(this.categories.size) { _ -> false }
        for (category in categories) {
            val btn = createCategoryButton(nestedView, category)
            btn.setOnClickListener {
                onCategoryClick(it)
            }
        }
    }

    private fun onCategoryClick(btn: View) {
        val id = Integer.parseInt(btn.tag.toString().split("_")[1])
        // Check if btn is already selected
        if (isSelected[id]) {
            isSelected[id] = false
            selectedCategories.forEach {
                if (it == categories[id]) {
                    selectedCategories.remove(it)
                    btn.alpha = 1f
                    return
                }
            }
        }
        isSelected[id] = true
        selectedCategories.add(categories[id])
        btn.alpha = 0.5f
    }

    private fun createCategoryButton(layout: LinearLayout, category: ExerciseCategory): Button {
        // Create and configure the button
        val btn = Button(this)
        btn.text = category.name
        // Add the index of the exercise in the list so I may extract that information
        // without iterating through all the elements
        btn.tag = category.name.lowercase() + "_" + exerciseIndex.toString()
        exerciseIndex++

        btn.setBackgroundResource(category.image)
        btn.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 600)
        btn.setTextColor(Color.parseColor("#ffffff"))
        btn.textSize = 35f;
        btn.setTypeface(btn.typeface, Typeface.BOLD)
        layout.addView(btn)
        return btn
    }
}