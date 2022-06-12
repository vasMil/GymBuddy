package com.example.myapplication.boundaries

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R


// How to change the starting activity of the application
// 1. app/manifests/AndroidManifest.xml, line 13 change ChooseCategoryProgram to your activity class
// 2. Go to Run -> Edit Configurations -> app -> Launch Options ->
// set Launch to Specified Activity
// click on the ... to the right of the Activity box and choose you activity class
// build and Run

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.loginButton)
        loginBtn.setOnClickListener {
            val intentLogin = Intent(this, LoginBoundary::class.java)
            startActivity(intentLogin)
        }
        // TODO: Add functionality for signIn button
        val signInBtn = findViewById<Button>(R.id.submit_loginButton)
    }
}