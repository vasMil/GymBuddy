package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ReportList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.report_list)

        val actionBar = supportActionBar

            actionBar!!.title = "Report List"

            actionBar.setDisplayHomeAsUpEnabled(true)
    }
}