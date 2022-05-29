package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserProfile : AppCompatActivity() {
    private val user: Athlete

    init {
        // TODO: Delete this and implement login functionality
        val auth = authService()
        user = auth.authUser("athlete", "athlete") as Athlete
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setup_prof)
        supportActionBar?.apply {
            title = "User Profile"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        // Setup Views
        val usernameView = findViewById<TextView>(R.id.username_texView)
        val changeGymButton = findViewById<Button>(R.id.changeGym_button)
        val gymView = findViewById<TextView>(R.id.gym_textView)

        usernameView.text = user.name
        if(user.currentGym === null) {
            changeGymButton.text = "Add Gym"
        }
        else {
            gymView.text = user.currentGym!!.name
        }
    }
}