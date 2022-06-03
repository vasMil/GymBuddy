package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginBoundary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setup_prof)
        supportActionBar?.apply {
            title = "Login"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        val usernameField = findViewById<EditText>(R.id.login_username)
        val passwordField = findViewById<EditText>(R.id.login_password)
        val submitBtn = findViewById<Button>(R.id.submit_loginButton)

        submitBtn.setOnClickListener {
            val sesOk = UserSession.createSession(usernameField.toString(),
                passwordField.toString());
            if (!sesOk) {
                Toast.makeText(this@LoginBoundary, "Login Failed!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            UserSession.getUser<Athlete>().weight;
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }
    }
}