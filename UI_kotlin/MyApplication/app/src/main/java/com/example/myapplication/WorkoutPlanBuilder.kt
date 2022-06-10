package com.example.myapplication

import java.lang.Exception

object WorkoutPlanBuilder {
    private var workoutPlan: WorkoutPlan? = null;

    // Helper in order to avoid serializing the ExerciseCategory array
    lateinit var currentDayCategories: Array<ExerciseCategory>
    lateinit var currentDayName: String
    lateinit var currentDaySelectedExercises: Array<Exercise>

    var dayCount = 1 // Refers to the next day to be configured
    var isComplete = false

    fun initWorkoutPlan(
        numOfDays : Int, idealAthWeight: Int, idealAthHeight: Int, name: String, id: Int) {
        if (workoutPlan == null) {
            workoutPlan = WorkoutPlan(numOfDays, idealAthWeight, idealAthHeight, name, id)
        }
    }

    fun initWorkoutPlan(
        numOfDays : Int, idealAthWeight: Int, idealAthHeight: Int, name: String, id: Int,
        userLevel: UserLevel) {
        if (workoutPlan == null) {
            workoutPlan = WorkoutPlan(numOfDays, idealAthWeight, idealAthHeight, name,
                id, userLevel)
        }
    }

    fun appendDay() {
        if(workoutPlan == null)
            throw Exception("Uninitialized WorkoutPlan")
        workoutPlan!!.workoutDays.add(WorkoutDay(currentDayName, currentDaySelectedExercises))
        setIfComplete()
    }

    // Save workout plan in user
    fun saveWorkoutPlan() {
        if(workoutPlan == null)
            throw Exception("Uninitialized WorkoutPlan")
        UserSession.getUser<Athlete>().workoutPlan = workoutPlan!!.deepCopy()
        if(!isComplete)
            throw Exception("Workout Plan not ready")
        cleanBuilder()
    }

    // Inform the boundary that the workout plan is ready
    private fun setIfComplete() {
        if (dayCount == workoutPlan!!.numOfDays) {
            isComplete = true
            return
        }
        dayCount++
    }

    // In order to get the builder ready for the next workout plan to be created
    private fun cleanBuilder() {
        workoutPlan = null
        dayCount = 1
        isComplete = false
        currentDayCategories = arrayOf()
        currentDayName = ""
    }
}