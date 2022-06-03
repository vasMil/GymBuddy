package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserProfile : AppCompatActivity() {
    private lateinit var user: Athlete

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setup_prof)
        supportActionBar?.apply {
            title = "User Profile"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        // Extract the user using UserSession
        this.user = UserSession.getUser<Athlete>()

        // Setup Views
        val usernameView = findViewById<TextView>(R.id.username_texView)
        val changeGymButton = findViewById<Button>(R.id.changeGym_button)
        val gymView = findViewById<TextView>(R.id.gym_textView)
        val becomeTrainer = findViewById<Button>(R.id.BecomeTrainer_button)

        usernameView.text = user.name
        if(user.currentGym === null) {
            changeGymButton.text = "Add Gym"
        }
        else {
            gymView.text = user.currentGym!!.name
        }

        // Add event listener on changeGym button so it redirects to the MapBoundary
        changeGymButton.setOnClickListener {
            val intentMap = Intent(this, MapBoundary::class.java)
            startActivity(intentMap)
        }
    }
}