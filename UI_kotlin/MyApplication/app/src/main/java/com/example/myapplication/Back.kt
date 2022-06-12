package com.example.myapplication

class Back : ExerciseCategory {
    override var name = "Back"
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
        val deadlift = Exercise("Deadlift", 4, 6, UserLevel.ADVANCED)
        val pullUps = Exercise("Pull Ups", 4, 10, UserLevel.INTERMEDIATE)
        val bentOverRow = Exercise("Bent-Over Row", 4, 10, UserLevel.BEGINNER, 130, 0)
        val chestSupportedRow = Exercise("Chest Supported Row", 3, 8, UserLevel.BEGINNER,0, 150)
        val latPulldown = Exercise("Lat Pulldown", 4, 10, UserLevel.BEGINNER)
        val trxSuspensionRow = Exercise("Trx Suspension Row", 3, 8, UserLevel.INTERMEDIATE, 0, 150)
        exercises.plusAssign(
            listOf(deadlift, pullUps, bentOverRow,
                chestSupportedRow, latPulldown, trxSuspensionRow)
        )
    }
}