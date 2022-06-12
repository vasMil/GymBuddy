package com.example.myapplication.entities.exercise_categories

import com.example.myapplication.R
import com.example.myapplication.entities.Exercise
import com.example.myapplication.entities.ExerciseCategory
import com.example.myapplication.entities.UserLevel

class Legs : ExerciseCategory {
    override var name = "Legs"
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
        val frontSquat = Exercise("Front Squat", 4, 10, UserLevel.INTERMEDIATE, 120, 120)
        val walkingLunges = Exercise("Walking Lunges", 4, 10, UserLevel.BEGINNER, 0, 140)
        val stepUp = Exercise("Stepup", 4, 10, UserLevel.BEGINNER, 0, 150)
        val gluteBridge = Exercise("Glute Bridge", 4, 10, UserLevel.BEGINNER,0, 100)
        val olympicLift = Exercise("Olympic Lift", 3, 6, UserLevel.ADVANCED, 140, 150)
        val deadlift = Exercise("Deadlift", 3, 8, UserLevel.ADVANCED, 120, 180)
        exercises.plusAssign(
            listOf(frontSquat, walkingLunges, stepUp, gluteBridge, olympicLift, deadlift)
        )
    }
}