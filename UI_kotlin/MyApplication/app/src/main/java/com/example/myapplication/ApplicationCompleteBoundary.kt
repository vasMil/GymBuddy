package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ApplicationCompleteBoundary : AppCompatActivity() {
    private lateinit var trainerApplication: TrainerApplication;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.application_complete)
        this.title = "Trainer Application Result"

        trainerApplication = intent.getSerializableExtra("trainerApplication")
                as TrainerApplication

        val message = findViewById<TextView>(R.id.applicationMessage)
        if (trainerApplication.isApproved) {
            message.text = "Application Approved"
            // Remove application from Athlete class
            UserSession.getUser<Athlete>().trainerApplication = null
            // TODO: Pass control to promote Athlete To Trainer UseCase
        }
        else {
            message.text = "Application Denied!"
            val reason = findViewById<TextView>(R.id.reasonOfDenial)
            reason.text = trainerApplication.reasonOfDenial

            // Remove application from Athlete class
            UserSession.getUser<Athlete>().trainerApplication = null
        }

        // Cleanup after bypassing the admin check
        UserSession.removeAdminCredentials()

        val backProf = findViewById<Button>(R.id.goToProfile)
        backProf.setOnClickListener {
            startActivity(Intent(this, UserProfile::class.java))
        }

    }

}