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
//        val back = Back()
//        val shoulders = Shoulders()
//        val cardio = Cardio()
        categories.add(chest)
        categories.add(arms)
        categories.add(legsCategory)
//        categories.add(back)
//        categories.add(shoulders)
//        categories.add(cardio)
    }
}