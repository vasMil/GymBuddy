package com.example.myapplication.entities.exercise_categories

import com.example.myapplication.R
import com.example.myapplication.entities.Exercise
import com.example.myapplication.entities.ExerciseCategory
import com.example.myapplication.entities.UserLevel

class Chest : ExerciseCategory {
    override var name = "Chest"
    override var exercises = mutableListOf<Exercise>()
    override var image: Int = R.drawable.category_placeholder

    override fun getExercise(weight: Int, height: Int, level: UserLevel): Exercise? {
        exercises.forEach { exercise ->
            if (exercise.canRecommend(weight, height, level)) {
                return exercise
            }
        }
        return null
    }

    override fun fetchExercises() {
        val benchPress = Exercise("Bench Press", 4, 10, UserLevel.BEGINNER)
        val chestFly = Exercise("Chest Fly", 4, 10, UserLevel.BEGINNER)
        val pushUp = Exercise("Push Up", 4, 10, UserLevel.BEGINNER)
        val bandChestFly = Exercise("BandChestFly", 3, 8, UserLevel.INTERMEDIATE,0, 150)
        val cableFly = Exercise("Cable Fly", 4, 10, UserLevel.INTERMEDIATE)
        val declineBumbellBenchPress = Exercise("Decline Bumbell Bench Press", 4, 10, UserLevel.ADVANCED)
        exercises.addAll(
            listOf(benchPress, chestFly, pushUp,
                bandChestFly, bandChestFly, cableFly, declineBumbellBenchPress)
        )
    }
}