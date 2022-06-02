package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class TrainerApplicationBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trainer_application)

        val actionbar = supportActionBar
        val documentName = findViewById<TextView>(R.id.documentName)
        val ss:String = intent.getStringExtra("docName").toString()
        this.title = "Trainer Application Boundary"
        with(actionbar) {
            this!!.title = "Trainer Application Boundary"
            setDisplayHomeAsUpEnabled(true)

        }
        //take random numbers for the examination of approve and disapprove (admin's work)
        val list = listOf(0, 1)
        val number = list.random()

        if( number == 1)
            displayAppComp()
        else
            displayAppDis()



    }




        //
        //
       // val snack2 = Snackbar.make(findViewById<Button>(R.id.uploadCertificatesBtn), "Application Disapproved", Snackbar.LENGTH_SHORT).show()

    private fun displayAppComp(){
        //val intent = Intent(this, ApplicationCompleteBoundary :: class.java )
        //startActivity(intent)
        Toast.makeText(this@TrainerApplicationBoundary, "Application Approved", Toast.LENGTH_LONG).show();
    }

    private fun displayAppDis(){
        //val intent = Intent(this, ApplicationDeniedBoundary:: class.java )
        //startActivity(intent)
        Toast.makeText(this@TrainerApplicationBoundary, "Application Disapproved", Toast.LENGTH_LONG).show();
    }

}
