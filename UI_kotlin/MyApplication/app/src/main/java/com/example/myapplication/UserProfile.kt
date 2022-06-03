package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class UserProfile : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var user: Athlete

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
        setContentView(R.layout.setup_prof)
        supportActionBar?.apply {
            title = "User Profile"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        setupNavigation()
        // Extract the user using UserSession
        this.user = UserSession.getUser<Athlete>()

        // Setup Views
        val usernameView = findViewById<TextView>(R.id.username_texView)
        val changeGymButton = findViewById<Button>(R.id.changeGym_button)
        val gymView = findViewById<TextView>(R.id.gym_textView)
        val buttonBecomeTrainer = findViewById<Button>(R.id.BecomeTrainer_button)

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

        // Add event listener on become trainer
        buttonBecomeTrainer.setOnClickListener{
            val intent = Intent (this, UploadDocumentsBoundary::class.java )
            startActivity(intent)
        }
    }

    private fun setupNavigation() {
        this.drawerLayout = findViewById(R.id.drawerLayout)
        NavigationUtils.setupNavigation(this, drawerLayout, supportActionBar)
    }
}