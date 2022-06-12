package com.example.myapplication.boundaries

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.services.CategoryService
import com.example.myapplication.entities.ExerciseCategory
import com.example.myapplication.R
import java.io.Serializable

class ChooseCategoryBoundary : AppCompatActivity() {
    private var categories: Array<ExerciseCategory>
    private var exerciseIndex = 0
    private var rankingUseCase = false

    init {
        val categoryService = CategoryService()
        categoryService.fetchCategories()
        categories = categoryService.categories.toTypedArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            title = "Workout"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        setContentView(R.layout.choose_category_boundary)
        displayCategories()

        rankingUseCase = intent.getBooleanExtra("rankingUseCase", false)
    }

    private fun displayCategories() {
        val mainLayout = findViewById<LinearLayout>(R.id.exerciseScrollView)
        for (category in categories) {
            val btn = createCategoryButton(mainLayout, category)
            btn.setOnClickListener {
                intentChooseExerciseBoundary(category)
            }
        }
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

    private fun intentChooseExerciseBoundary(category: ExerciseCategory) {
        // Create the instance and move to it
        val intent = Intent(this, ChooseExerciseBoundary::class.java)
        intent.putExtra("category", category as Serializable)
        intent.putExtra("rankingUseCase", rankingUseCase)
        startActivity(intent)
    }
}