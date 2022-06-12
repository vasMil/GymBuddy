package com.example.myapplication.boundaries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

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
            Toast.makeText(this@TrainerProfileBoundary,
                "Request Sent to Trainer", Toast.LENGTH_SHORT).show()
            val intent = Intent (this, HomePageBoundary ::class.java)
            startActivity(intent)
        }


        reject.setOnClickListener {
            val intent = Intent (this, TrainersListBoundary ::class.java)
            startActivity(intent)
        }

    }
}