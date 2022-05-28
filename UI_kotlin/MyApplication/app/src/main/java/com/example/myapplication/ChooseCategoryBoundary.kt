package com.example.myapplication

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ChooseCategoryBoundary : AppCompatActivity() {
    var categories: List<ExerciseCategory>

    init {
        val categoryService = CategoryService()
        categoryService.fetchCategories()
        categories = categoryService.categories.toList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            title = "Workout"
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#F16D22")))
        }
        setContentView(R.layout.choose_category_boundary)
        displayCategories()
    }

    private fun displayCategories() {
        val mainLayout = findViewById<LinearLayout>(R.id.categoryScrollView)
        for (category in categories) {
            addCategoryButton(mainLayout, category)
        }
    }

    private fun addCategoryButton(layout: LinearLayout, category: ExerciseCategory) {
        // Create and configure the button
        val btn = Button(this)
        btn.text = category.name
        btn.tag = category.name
        btn.setBackgroundResource(category.image)
        btn.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 600)
        btn.setTextColor(Color.parseColor("#ffffff"))
        btn.textSize = 35f;
        btn.setTypeface(btn.typeface, Typeface.BOLD)
        layout.addView(btn)
    }
}