package com.example.myapplication.entities

import java.io.Serializable

interface ExerciseCategory : Serializable{
    var name: String
    var exercises: MutableList<Exercise>
    var image: Int

    fun getExercise(weight: Int, height: Int, level: UserLevel): Exercise?

    fun addExercise(exercise: Exercise) {
        exercises?.add(exercise)
    }

    fun removeExercise(exercise: Exercise) {
        exercises?.remove(exercise)
    }

    fun fetchExercises()
}