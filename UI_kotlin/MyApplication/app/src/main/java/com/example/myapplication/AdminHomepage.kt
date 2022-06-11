package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class AdminHomepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_homepage)

        val actionBar = supportActionBar

        actionBar!!.title = "Admin Homepage"




        val reportListBtn = findViewById<Button>(R.id.report_listBtn)
        reportListBtn.setOnClickListener {
            val intent = Intent(this , ReportList::class.java)

        val report_listBtn = findViewById<Button>(R.id.report_listBtn)
        report_listBtn.setOnClickListener {
            val intent = Intent(this , ReportListBoundary::class.java)

            startActivity(intent)

            
        }
    }
}