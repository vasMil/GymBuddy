package com.example.myapplication.entities.exercise_categories

import com.example.myapplication.R
import com.example.myapplication.entities.Exercise
import com.example.myapplication.entities.ExerciseCategory
import com.example.myapplication.entities.UserLevel

class Arms : ExerciseCategory {
    override var name = "Arms"
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
        val standingBumbellCurl = Exercise("Standing Bumbell Curl", 4, 10, UserLevel.BEGINNER)
        val standingBarbellCurl = Exercise("Standing Barbell Curl", 4, 10, UserLevel.BEGINNER)
        val ezBarPreacherCurl = Exercise("EZ-Bar Preacher Curl", 4, 10, UserLevel.BEGINNER, 130, 0)
        val crucifixCurl = Exercise("Crucifix Curl", 3, 8, UserLevel.INTERMEDIATE,0, 150)
        val hammerCurl = Exercise("Hammer Curl", 4, 10, UserLevel.BEGINNER)
        val tricepsPressdown = Exercise("Triceps Pressdown", 3, 8, UserLevel.BEGINNER, 0, 150)
        val ezBarSkullCrushers = Exercise("EZ Bar Skull Crushers", 3, 8, UserLevel.ADVANCED)
        exercises.plusAssign(
            listOf(standingBumbellCurl, standingBarbellCurl, ezBarPreacherCurl,
                crucifixCurl, hammerCurl, tricepsPressdown, ezBarSkullCrushers)
        )
    }
}