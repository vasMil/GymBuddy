package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

class RegisterAttemptBoundary : AppCompatActivity() {
    private lateinit var confirmButton: Button
    private lateinit var acceptSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_attempt_boundary)
    }

    private fun handleConfirmation() {
        val switch = findViewById<Switch>(R.id.switch1)
        if(switch.isChecked) {

            val intent = Intent(this, LeaderboardBoundary::class.java)
            startActivity(intent)
        }
        else {

        }
    }


}