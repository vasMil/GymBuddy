package com.example.myapplication

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SetupDayOfWorkoutBoundary : AppCompatActivity() {
    private var dayIndex = 1
    private var exerciseIndex = 0
    private var categories: Array<ExerciseCategory>
    private lateinit var workoutPlan: WorkoutPlan
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
        workoutPlan = intent.getSerializableExtra("workoutPlan") as WorkoutPlan
        displayCategories()

        val doneBtn = findViewById<Button>(R.id.done_button)
        doneBtn.setOnClickListener {
            // TODO: Intent to a boundary displaying all the exercises included in each category
            // Do not forget to putExtra both the WorkoutPlan as well as the categories
        }
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