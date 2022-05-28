package com.example.myapplication

class Legs : ExerciseCategory {
    override var name = "Legs"
    override var exercises: MutableList<Exercise>? = null

    override fun getExercise(weight: Int, height: Int, level: UserLevel): Exercise? {
        exercises?.forEach { exercise ->
            if (exercise.canRecommend(weight, height, level)) {
                return exercise
            }
        }
        return null
    }

    override fun fetchExercises() {
        var frontSquat = Exercise("Front Squat", 4, 10, UserLevel.INTERMEDIATE, 120, 120)
        var walkingLunges = Exercise("Walking Lunges", 4, 10, UserLevel.BEGINNER, 0, 140)
        var stepUp = Exercise("Stepup", 4, 10, UserLevel.BEGINNER, 0, 150)
        var gluteBridge = Exercise("Glute Bridge", 4, 10, UserLevel.BEGINNER,0, 100)
        var olympicLift = Exercise("Olympic Lift", 3, 6, UserLevel.ADVANCED, 140, 150)
        var deadlift = Exercise("Deadlift", 3, 8, UserLevel.ADVANCED, 120, 180)
        exercises?.plusAssign(
            listOf(frontSquat, walkingLunges, stepUp, gluteBridge, olympicLift, deadlift)
        )
    }
}