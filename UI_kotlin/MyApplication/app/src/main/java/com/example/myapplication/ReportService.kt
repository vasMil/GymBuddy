package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ReportService : AppCompatActivity() {
        var report: MutableList<Report> = mutableListOf()
        init {
            fetchReports()
        }

    private fun fetchReports() {
        if(report.isNotEmpty()) {
            return;
        }
        //val reportButton = findViewById<Button>(R.id.report_btn)



    }



}