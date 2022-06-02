package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class TrainerApplicationBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trainer_application)
        displayTrainerApplication()

    }

    private fun displayTrainerApplication() {
        val actionbar1 = supportActionBar
        this.title = "Trainer Application Boundary"
        with(actionbar1) {
            this!!.title = "Trainer Application Boundary"
            setDisplayHomeAsUpEnabled(true)

        }

        //
        //
       // val snack2 = Snackbar.make(findViewById<Button>(R.id.uploadCertificatesBtn), "Application Disapproved", Snackbar.LENGTH_SHORT).show()
    }
    private fun displayAppComp(){
        val intent = Intent(this, ApplicationCompleteBoundary :: class.java )
        startActivity(intent)

    }

    private fun displayAppDis(){
        val intent = Intent(this, ApplicationDeniedBoundary:: class.java )
        startActivity(intent)

    }

}
