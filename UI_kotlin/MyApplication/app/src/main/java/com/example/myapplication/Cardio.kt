package com.example.myapplication

class Cardio : ExerciseCategory {
    override var name = "Cardio"
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
        val elliptical = Exercise("Elliptical", 0, 0, UserLevel.BEGINNER)
        val stairs = Exercise("Stair Climbing", 0, 0, UserLevel.BEGINNER)
        val treadmill = Exercise("Treadmill", 0, 0, UserLevel.BEGINNER, 130, 0)
        val swimming = Exercise("Swimming", 0, 0, UserLevel.BEGINNER, 0, 150)
        val exerciseBike = Exercise("Exercise bike", 0, 0, UserLevel.BEGINNER)
        exercises.plusAssign(
            listOf(
                elliptical, stairs, treadmill,
                swimming, exerciseBike)
        )
    }
}