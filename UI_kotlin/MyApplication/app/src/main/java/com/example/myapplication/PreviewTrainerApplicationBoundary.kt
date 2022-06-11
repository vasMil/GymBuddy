package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class PreviewTrainerApplicationBoundary : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preview_trainer_application)

        this.title = "Preview Trainer Application"

        val trainerApplication = intent.getSerializableExtra("trainerApplication")
                as TrainerApplication
        val docsView = findViewById<TextView>(R.id.documentName)
        docsView.text = trainerApplication.userDocuments

        // Add the date provided by the TrainerApplication class
        val dateView = findViewById<TextView>(R.id.textView_applicationDate)
        dateView.text = "Date: " + trainerApplication.date.toString()

        // Add functionality to submit button
        val submitBtn = findViewById<Button>(R.id.submit_application)
        submitBtn.setOnClickListener {
            Toast.makeText(this@PreviewTrainerApplicationBoundary,
                "Application Submitted!", Toast.LENGTH_SHORT).show()
            UserSession.getUser<Athlete>().trainerApplication = trainerApplication
            startActivity(Intent(this, UserProfile::class.java))
        }
    }
}
