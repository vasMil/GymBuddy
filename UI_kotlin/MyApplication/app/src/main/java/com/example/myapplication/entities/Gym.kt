package com.example.myapplication.entities

import java.io.Serializable

class Gym(name: String, location: Pair<Double, Double>, googleImage: Int) : Serializable {
    val name: String = name
    var location: Pair<Double, Double> = location
    var rating: Int = -1
    var noOfGymBuddyUsers: Int = 0
    var noRatingVotes: Int = 0
    val googleImage: Int = googleImage
}