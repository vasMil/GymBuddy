package com.example.myapplication

import android.provider.MediaStore

class Report(name : String,  report: String, accused : String, accuser : String) {
        val name : String = name
        val report : String = report
        val accused : String = accused
        val accuser : String = accuser




        fun fetchReports () {
                val report0 = Report ( "Report 0", "He did that", "Mr B", "Mr A")
                val report1 = Report ("Report 1", "He did that2", "Ms C", "Mr B")
                val report2 = Report ("Report 2", "He did that3", "Mr D", "Ms C")
                val report3 = Report ("Report 3", "He did that4", "Mr A", "Mr D")



        }


}