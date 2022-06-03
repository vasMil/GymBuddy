package com.example.myapplication

class WorkoutPlan(numOfDays : Int, idealAthWeight: Int, idealAthHeight: Int, name: String, id: Int)
{

    var minAthLevel: UserLevel = UserLevel.BEGINNER
    var numOfDays = numOfDays
    var idealAthWeight = idealAthWeight
    var idealAthHeight = idealAthHeight
    var name = name
    var id = id

    constructor(numOfDays: Int, idealAthWeight: Int,
                idealAthHeight: Int, name: String,id: Int, minAthLevel: UserLevel)
     : this (numOfDays, idealAthWeight, idealAthHeight, name, id) {

    }

}