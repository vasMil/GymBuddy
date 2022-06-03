package com.example.myapplication

import android.provider.MediaStore

class Report(name : String,  report: String, accuser : User, accused : User, video : MediaStore.Video) {
        val name : String = name
        val accuser : User = accuser
        val video : MediaStore.Video = video
        val accused : User = accused
        val report : String = report


}