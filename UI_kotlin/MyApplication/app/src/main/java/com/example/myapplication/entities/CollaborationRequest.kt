package com.example.myapplication.entities

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class CollaborationRequest(val athleteId: Int, val athleteName: String, val message: String) {
    @RequiresApi(Build.VERSION_CODES.O)
    val date: LocalDateTime = LocalDateTime.now()

}