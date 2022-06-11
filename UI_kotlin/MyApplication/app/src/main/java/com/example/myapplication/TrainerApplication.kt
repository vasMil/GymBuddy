package com.example.myapplication

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.time.LocalDateTime

class TrainerApplication(userDocuments: String) : Serializable {
    var hasBeenUpdated: Boolean = true

    var userDocuments: String = userDocuments
        set(value) {
            returnIfNotAthlete()
            field = value
            hasBeenUpdated = true
        }

    @RequiresApi(Build.VERSION_CODES.O)
    val date: LocalDateTime = LocalDateTime.now()

    var isApproved = false
        set(value) { // approveApplication() - disapproveApplication()
            returnIfNotAdmin()
            field = value
            hasBeenUpdated = false
        }

    var reasonOfDenial: String? = null
        set(value) { // updateReasonOfDenial()
            returnIfNotAdmin()
            field = value
        }

    private fun returnIfNotAdmin() {
        if(UserSession.getUser<Admin>() == null) {
            return
        }
    }

    private fun returnIfNotAthlete() {
        if(UserSession.getUser<Athlete>() == null) {
            return
        }
    }
}