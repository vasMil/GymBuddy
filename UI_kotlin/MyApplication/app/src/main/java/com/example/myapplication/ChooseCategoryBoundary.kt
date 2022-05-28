package com.example.myapplication

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
        setContentView(R.layout.choose_category_boundary)
        val mainLayout = findViewById<LinearLayout>(R.id.chooseCategoryLayout)
        displayCategories(mainLayout)
    }

    private fun displayCategories(layout: LinearLayout) {
        for (category in categories) {
            val btn = Button(this)
            btn.text = category.name
            layout.addView(btn)
        }

    }
}