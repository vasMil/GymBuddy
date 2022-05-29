package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UserProfile : AppCompatActivity() {
    private val user: User

    init {
        // TODO: Delete this and implement login functionality
        val auth = authService()
        user = auth.authUser("athlete", "athlete")!!
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setup_prof)
        supportActionBar?.apply {
            title = "User Profile"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
    }
}