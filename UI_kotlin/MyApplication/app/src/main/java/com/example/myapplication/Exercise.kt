package com.example.myapplication

import java.io.Serializable

class Exercise(
    name: String, sets: Int, reps: Int, minLevel: UserLevel
) : Serializable {
    var name = name
    var minLevel = minLevel
    var maxWeight: Int? = null
    var minHeight: Int? = null

    // Secondary Constructor
    constructor(name: String, sets: Int, reps: Int, minLevel: UserLevel, maxWeight: Int, minHeight: Int):
            this(name, sets, reps, minLevel) {
                this.maxWeight = maxWeight
                this.minHeight = minHeight
            }

    fun canRecommend(weight: Int, height: Int, level: UserLevel): Boolean {
        when(this.maxWeight?.let { it < weight}) {
            true -> {return false}
        }
        when(this.minHeight?.let { it > height}) {
            true -> {return false}
        }
        when(this.minLevel?.let { it > level}) {
            true -> {return false}
        }
        return true
    }
}