package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


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
    }
}