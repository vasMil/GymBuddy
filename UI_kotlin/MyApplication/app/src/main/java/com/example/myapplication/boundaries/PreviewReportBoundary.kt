package com.example.myapplication.boundaries

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.services.ReportService

class PreviewReportBoundary : AppCompatActivity() {
    private val reportService: ReportService = ReportService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_report_boundary)
        supportActionBar?.apply {
            title = "Report"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
            reportService.fetchReports()
            var report = intent.getSerializableExtra("Report")
        }
    }




    private fun displayReports() {
        // fetch the reports
        // report.fetchReports()
    }
}

