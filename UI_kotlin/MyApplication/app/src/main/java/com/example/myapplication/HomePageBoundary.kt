package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class HomePageBoundary : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view_wp)
        supportActionBar?.apply {
            title = "Home"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        setupNavigation()

        val startWorkout = findViewById<Button>(R.id.home_btn1)
        val viewWorkout = findViewById<Button>(R.id.home_btn2)
        val findTrainer = findViewById<Button>(R.id.home_btn3)
        val searchForGB = findViewById<Button>(R.id.home_btn4)

        // If the Athlete has selected a workout plan then he may view it
        // else he has the option to find - create one
        if(UserSession.getUser<Athlete>().workoutPlan != null) {
            // TODO: Small use case we have not developed
            viewWorkout.text = "View workout plan"
        }
        else {
            viewWorkout.text = "Find a workout plan"
            val intentFindWorkout = Intent(this, FindWorkoutPlanBoundary::class.java)
            startActivity(intentFindWorkout)
        }

        /*startWorkout.setOnClickListener{
            if(/*Athlete has a program*/) {
                val intentSW = Intent(this, WorkoutPageBoundary::class.java)
                startActivity(intentSW)
            }
            else{

            }
        }

         */
    }

    private fun setupNavigation() {
        this.drawerLayout = findViewById(R.id.drawerLayout)
        NavigationUtils.setupNavigation(this, drawerLayout, supportActionBar)
    }
}