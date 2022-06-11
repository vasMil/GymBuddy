package com.example.myapplication

import android.os.Bundle
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
            // TODO: Promote Athlete to Trainer
        }
        else {
            message.text = "Application Denied!"
            val reason = findViewById<TextView>(R.id.reasonOfDenial)
            reason.text = trainerApplication.reasonOfDenial
        }

    }

}