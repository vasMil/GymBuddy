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
        legsCategory.image = R.drawable.legs_img
        val arms = Arms()
        arms.image = R.drawable.arms
        val chest = Chest()
        chest.image = R.drawable.chest
        val back = Back()
        back.image = R.drawable.back
        val shoulders = Shoulders()
        shoulders.image = R.drawable.shoulders
        val cardio = Cardio()
        cardio.image = R.drawable.cardio
        categories.add(chest)
        categories.add(arms)
        categories.add(legsCategory)
        categories.add(back)
        categories.add(shoulders)
        categories.add(cardio)
    }
}