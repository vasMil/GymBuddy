package com.example.myapplication.entities

import com.example.myapplication.R

class Shoulders : ExerciseCategory {
    override var name = "Shoulders"
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
        val arnoldPress = Exercise("Arnold Press", 4, 10, UserLevel.INTERMEDIATE)
        val pushPress = Exercise("Push Press", 4, 10, UserLevel.INTERMEDIATE)
        val bottomsUp = Exercise("Bottoms Up Kettelbell Press", 4, 10, UserLevel.BEGINNER, 130, 0)
        val seatedRow = Exercise("Wide grip seated row", 3, 8, UserLevel.BEGINNER, 0, 150)
        val landminePress = Exercise("Half-Kneeling Landmine Press", 4, 10, UserLevel.ADVANCED)
        val lateralRaise = Exercise("Leaning Lateral Raise", 3, 8, UserLevel.INTERMEDIATE, 0, 150)
        exercises.plusAssign(
            listOf(
                arnoldPress, pushPress, bottomsUp,
                seatedRow, landminePress, lateralRaise
            )
        )
    }
}