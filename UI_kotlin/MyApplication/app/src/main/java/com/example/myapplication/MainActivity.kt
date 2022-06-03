package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


// How to change the starting activity of the application
// 1. app/manifests/AndroidManifest.xml, line 13 change ChooseCategoryProgram to your activity class
// 2. Go to Run -> Edit Configurations -> app -> Launch Options ->
// set Launch to Specified Activity
// click on the ... to the right of the Activity box and choose you activity class
// build and Run

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()

        val loginBtn = findViewById<Button>(R.id.loginButton)
        loginBtn.setOnClickListener {
            val intentLogin = Intent(this, LoginBoundary::class.java)
            startActivity(intentLogin)
        }
        // TODO: Add functionality for signIn button
        val signInBtn = findViewById<Button>(R.id.submit_loginButton)
    }

    private fun setupNavigation() {
        this.drawerLayout = findViewById(R.id.drawerLayout)
        NavigationUtils.setupNavigation(this, drawerLayout, supportActionBar)
    }
}