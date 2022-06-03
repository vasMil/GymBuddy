package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import android.widget.Toast

class MyProfileBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_become_trainer_prof)
        // get reference to button
        val buttonBecomeTrainer = findViewById<Button>(R.id.buttonBecomeTrainer)
        // set on-click listener
        buttonBecomeTrainer.setOnClickListener{
            val intent = Intent (this, UploadDocumentsBoundary::class.java )
            startActivity(intent)
        }
    }

}


