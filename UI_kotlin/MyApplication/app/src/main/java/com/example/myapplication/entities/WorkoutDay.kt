package com.example.myapplication.entities

class WorkoutDay(name: String, exercises: Array<Exercise>) {
    var name = name
    var exercises : Array<Exercise> = exercises

    /*override fun fetchExercises() {
        val standingBumbellCurl = Exercise("Standing Bumbell Curl", 4, 10, UserLevel.BEGINNER)
        val standingBarbellCurl = Exercise("Standing Barbell Curl", 4, 10, UserLevel.BEGINNER)
        val ezBarPreacherCurl = Exercise("EZ-Bar Preacher Curl", 4, 10, UserLevel.BEGINNER, 130, 0)
        val crucifixCurl = Exercise("Crucifix Curl", 3, 8, UserLevel.INTERMEDIATE,0, 150)
        val hammerCurl = Exercise("Hammer Curl", 4, 10, UserLevel.BEGINNER)
        val tricepsPressdown = Exercise("Triceps Pressdown", 3, 8, UserLevel.BEGINNER, 0, 150)
        val ezBarSkullCrushers = Exercise("EZ Bar Skull Crushers", 3, 8, UserLevel.ADVANCED)
        exercises.plusAssign(
            listOf(standingBumbellCurl, standingBarbellCurl, ezBarPreacherCurl,
                crucifixCurl, hammerCurl, tricepsPressdown, ezBarSkullCrushers)
        )
    }
*/
}