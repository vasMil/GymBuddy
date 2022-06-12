package com.example.myapplication

import java.lang.Exception

// Singleton
object UserSession {
    private val authService = AuthService()
    private var athlete: Athlete? = null
    private var  trainer: Trainer? = null
    private var admin: Admin? = null

    init {
        // TODO: Delete this and make main activity the initial activity
//        athlete = authService.authUser("athlete", "athlete") as Athlete
    }

    fun createSession(username: String, password: String): Boolean {
        val tempUser = authService.authUser(username, password)

        if (tempUser is Athlete) {
            this.athlete = tempUser
            return true
        }
        if (tempUser is Trainer) {
            this.trainer = tempUser
            return true
        }
        if (tempUser is Admin) {
            this.admin = tempUser
            return true
        }

        return false
    }

    fun <T> getUser(): T {
        if (athlete != null) {
            return athlete as T
        }
        if (trainer != null) {
            return trainer as T
        }
        if (admin != null) {
            return admin as T
        }
        throw Exception("There is no UserSession!")
    }

    fun bypassAdminCheck() {
        admin = authService.authUser("admin", "admin") as Admin
    }
    fun removeAdminCredentials() {
        admin = null
    }
}