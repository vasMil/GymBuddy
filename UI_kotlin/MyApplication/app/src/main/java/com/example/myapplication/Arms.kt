package com.example.myapplication

class Arms : ExerciseCategory {
    override var name = "Arms"
    override var exercises: MutableList<Exercise>? = null
    override var image: Int = R.drawable.category_placeholder

    override fun getExercise(weight: Int, height: Int, level: UserLevel): Exercise? {
        exercises?.forEach { exercise ->
            if (exercise.canRecommend(weight, height, level)) {
                return exercise
            }
        }
        return null
    }

    override fun fetchExercises() {
        var standingBumbellCurl = Exercise("Standing Bumbell Curl", 4, 10, UserLevel.BEGINNER)
        var standingBarbellCurl = Exercise("Standing Barbell Curl", 4, 10, UserLevel.BEGINNER)
        var ezBarPreacherCurl = Exercise("EZ-Bar Preacher Curl", 4, 10, UserLevel.BEGINNER, 130, 0)
        var crucifixCurl = Exercise("Crucifix Curl", 3, 8, UserLevel.INTERMEDIATE,0, 150)
        var hammerCurl = Exercise("Hammer Curl", 4, 10, UserLevel.BEGINNER)
        var tricepsPressdown = Exercise("Triceps Pressdown", 3, 8, UserLevel.BEGINNER, 0, 150)
        var ezBarSkullCrushers = Exercise("EZ Bar Skull Crushers", 3, 8, UserLevel.ADVANCED)
        exercises?.plusAssign(
            listOf(standingBumbellCurl, standingBarbellCurl, ezBarPreacherCurl,
                crucifixCurl, hammerCurl, tricepsPressdown, ezBarSkullCrushers)
        )
    }
}