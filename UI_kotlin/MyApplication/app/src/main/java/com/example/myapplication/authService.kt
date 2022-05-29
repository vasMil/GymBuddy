package com.example.myapplication

class authService {
    private var staticUserId = 0
        get() = field++

    fun authUser(username: String, password: String): UserInterface? {
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