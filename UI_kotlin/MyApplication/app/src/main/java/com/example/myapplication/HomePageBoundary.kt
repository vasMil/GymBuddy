package com.example.myapplication

//import android.content.Intent

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button

//import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class HomePageBoundary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view_wp)
        supportActionBar?.apply {
            title = "Home"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        val startWorkout = findViewById<Button>(R.id.home_btn1)
        val viewWorkout = findViewById<Button>(R.id.home_btn2)
        val findTrainer = findViewById<Button>(R.id.home_btn3)
        val searchForGB = findViewById<Button>(R.id.home_btn4)

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
}