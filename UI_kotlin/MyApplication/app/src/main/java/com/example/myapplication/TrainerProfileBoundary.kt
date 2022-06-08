package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class TrainerProfileBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainer_profile_boundary)
        val actionBar = supportActionBar

        actionBar!!.title = "Trainer's Profile"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val sendrequest = findViewById<Button>(R.id.Send_Request)
        val reject = findViewById<Button>(R.id.Reject)

        sendrequest.setOnClickListener {
            val intent = Intent (this, HomePageBoundary ::class.java)
            startActivity(intent)
        }


        reject.setOnClickListener {
            val intent = Intent (this, TrainersListBoundary ::class.java)
            startActivity(intent)
        }

    }
}