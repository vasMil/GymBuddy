package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ReportService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`report_service`)

        val actionBar = supportActionBar

        actionBar!!.title = "Report Service"
    }
}