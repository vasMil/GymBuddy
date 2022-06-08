package com.example.myapplication

import java.io.Serializable

class WorkoutPlan(numOfDays : Int, idealAthWeight: Int, idealAthHeight: Int, name: String, id: Int)
    : Serializable
{
    var minAthLevel: UserLevel = UserLevel.BEGINNER
    var numOfDays = numOfDays
    var idealAthWeight = idealAthWeight
    var idealAthHeight = idealAthHeight
    var name = name
    var workoutDays: MutableList<WorkoutDay> = mutableListOf()

    constructor(numOfDays: Int, idealAthWeight: Int,
                idealAthHeight: Int, name: String, id: Int, minAthLevel: UserLevel)
     : this (numOfDays, idealAthWeight, idealAthHeight, name, id) {
        this.minAthLevel = minAthLevel
    }
}