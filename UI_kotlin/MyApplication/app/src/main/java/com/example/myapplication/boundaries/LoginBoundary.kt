package com.example.myapplication.boundaries

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.entities.Athlete
import com.example.myapplication.R
import com.example.myapplication.entities.Admin
import com.example.myapplication.entities.UserSession

class LoginBoundary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        supportActionBar?.apply {
            title = "Login"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        val usernameField = findViewById<EditText>(R.id.login_username)
        val passwordField = findViewById<EditText>(R.id.login_password)
        val submitBtn = findViewById<Button>(R.id.submit_loginButton)

        submitBtn.setOnClickListener {
            val sesOk = UserSession.createSession(
                usernameField.text.toString(),
                passwordField.text.toString()
            );
            if (!sesOk) {
                Toast.makeText(this@LoginBoundary, "Login Failed!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if(UserSession.getUserType() == "admin") {
                startActivity(Intent(this, AdminHomepage::class.java))
            }
            if(UserSession.getUserType() == "trainer") {
                return@setOnClickListener
            }
            if(UserSession.getUserType() == "athlete") {
                val intent = Intent(this, HomePageBoundary::class.java)
                startActivity(intent)
                return@setOnClickListener
            }
        }
    }
}