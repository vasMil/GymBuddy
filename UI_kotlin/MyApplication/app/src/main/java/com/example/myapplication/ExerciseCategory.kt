package com.example.myapplication

interface ExerciseCategory {
    var name: String
    var exercises: MutableList<Exercise>?

    fun getExercise(weight: Int, height: Int, level: UserLevel): Exercise?

    fun addExercise(exercise: Exercise) {
        exercises?.add(exercise)
    }

    fun removeExercise(exercise: Exercise) {
        exercises?.remove(exercise)
    }

    fun fetchExercises()
}