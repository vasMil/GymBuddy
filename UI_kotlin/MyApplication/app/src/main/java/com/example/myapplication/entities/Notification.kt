package com.example.myapplication.entities

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class Notification(val message: String, val fromUser: User, val toUser: User) {
    @RequiresApi(Build.VERSION_CODES.O)
    val date = LocalDateTime.now()
    
}