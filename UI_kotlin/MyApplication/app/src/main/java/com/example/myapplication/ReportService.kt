package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ReportService : AppCompatActivity() {
        var reports: MutableList<Reports> = mutableListOf()
        init {
            fetchReports()
        }

    private fun fetchReports() {
        if(reports.isNotEmpty()) {
            return;
        }
        //val reportButton = findViewById<Button>(R.id.report_btn)



    }



}