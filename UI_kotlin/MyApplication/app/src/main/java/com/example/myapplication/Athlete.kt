package com.example.myapplication

class Athlete(name: String, id: Int, weight: Int, height: Int) : User(name, id)
{
    var level: UserLevel = UserLevel.BEGINNER
    var currentGym: Gym? = null
    var weight = weight
    var heightInCm = height
    var trainer: Trainer? = null
    var workoutPlan: WorkoutPlan? = null;

    constructor(name: String, id: Int,
                weight: Int, height: Int, level: UserLevel
    ) : this (name, id, weight, height) {

    }
}