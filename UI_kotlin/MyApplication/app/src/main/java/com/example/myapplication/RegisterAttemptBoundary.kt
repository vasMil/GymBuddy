package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RegisterAttemptBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_attempt_boundary)
    }

    private fun handleConfirmation() {
        if(switch1.isChecked) {
            Toast.makeText(this@RegisterAttemptBoudary, "Success!",
                Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this@RegisterAttemptBoudary, "Failed to upload video!",
                Toast.LENGTH_SHORT)
                .show()
        }
    }


}