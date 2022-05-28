package com.example.myapplication

class CategoryService {
    var categories: MutableList<ExerciseCategory> = mutableListOf()

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        if(categories.isNotEmpty()) {
            return;
        }
        val legsCategory = Legs()
        categories.add(legsCategory)
    }
}