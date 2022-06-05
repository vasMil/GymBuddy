package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast

class RegisterAttemptBoundary : AppCompatActivity() {
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_attempt_boundary)

        val sendBtn = findViewById<Button>(R.id.sendButton)
        sendBtn.setOnClickListener {
            handleConfirmation()
        }
    }

    private fun handleConfirmation() {
        val switch = findViewById<Switch>(R.id.switch1)
        if(switch.isChecked) {

            val intent = Intent(this, LeaderboardBoundary::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this@RegisterAttemptBoundary, "Upload video failed", Toast.LENGTH_SHORT).show()

        }
    }
}
