package com.example.myapplication.entities

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class Violation(val report: Report, val violCat: ViolationCategory) {
    @RequiresApi(Build.VERSION_CODES.O)
    val date = LocalDateTime.now()
    val adminId = UserSession.getUser<Admin>().id

    fun getType(): String {
        return violCat.name
    }
}