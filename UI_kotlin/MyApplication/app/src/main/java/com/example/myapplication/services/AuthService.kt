package com.example.myapplication.services

import com.example.myapplication.entities.Admin
import com.example.myapplication.entities.Athlete
import com.example.myapplication.entities.Trainer

class AuthService {
    private var staticUserId = 0
        get() = field++

    fun authUser(username: String, password: String): Any? {
        if(username == "admin" && password == "admin") {
            return Admin(staticUserId)
        }
        if(username == "athlete" && password == "athlete") {
            return Athlete("athlete", staticUserId, 67, 170)
        }
        if(username == "trainer" && password == "trainer") {
            return Trainer("trainer", staticUserId)
        }
        return null
    }
}