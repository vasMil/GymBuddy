package com.example.myapplication

class Gym(name: String, location: Pair<Double, Double>, googleImage: Int) {
    val name: String = name
    var location: Pair<Double, Double> = location
    var rating: Int? = null
    var noOfGymBuddyUsers: Int = 0
    var noRatingVotes: Int = 0
    val googleImage: Int = googleImage
}