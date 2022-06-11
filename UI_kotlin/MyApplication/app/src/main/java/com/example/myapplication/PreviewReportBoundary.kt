package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class PreviewReportBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_report_boundary)
        supportActionBar?.apply {
            title = "Report"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
            fetchReports()
            var Report = intent.getSerializableExtra("Report")
        }
    }


    private fun displayReports() {
        // fetch the reports
        // report.fetchReports()



    private fun fetchReports() {
        TODO("Not yet implemented")

    }
}

