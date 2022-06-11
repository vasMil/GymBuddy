package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class UserProfile : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var user: Athlete
    private lateinit var adminAccepts: Switch
    private lateinit var adminRejects: Switch

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
        val uploadVideoBtn = findViewById<Button>(R.id.upVideo_button)
        adminAccepts = findViewById(R.id.adminAccepts)
        adminRejects = findViewById(R.id.adminRejects)

        // Hide the switches
        adminAccepts.visibility = View.GONE
        adminRejects.visibility = View.GONE

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

        uploadVideoBtn.setOnClickListener {
            val intentCategories = Intent(this, ChooseCategoryBoundary::class.java)
            startActivity(intentCategories)
        }

        // Add event listener on become trainer
        buttonBecomeTrainer.setOnClickListener{
            onBecomeTrainer()
        }

        adminRejects.setOnClickListener {
            if(adminRejects.isChecked) {
                disableComplementarySwitch(it)
            }
        }
        adminAccepts.setOnClickListener {
            if(adminAccepts.isChecked) {
                disableComplementarySwitch(it)
            }
        }
    }

    private fun onBecomeTrainer() {
        val application = user.trainerApplication
        if(application == null) {
            // User has not yet applied to become trainer
            startActivity(Intent(this, UploadDocumentsBoundary::class.java))
            return
        }
        else if(!application.hasBeenUpdated){
            // Application has been evaluated by an admin
            val intentCompleteAplication = Intent(this,
                ApplicationCompleteBoundary::class.java)
            intentCompleteAplication.putExtra("trainerApplication", application)
            startActivity(intentCompleteAplication)
            return
        }
        if(adminAccepts.visibility == View.GONE || adminRejects.visibility == View.GONE) {
            // Application has not been evaluated
            Toast.makeText(this@UserProfile, "Application pending",
                Toast.LENGTH_SHORT).show()
            // Show the switches that will either approve or disapprove the application
            adminAccepts.visibility = View.VISIBLE
            adminRejects.visibility = View.VISIBLE
        }
        else {
            // Switches are already visible
            if(adminAccepts.isChecked) {
                // BYPASS THE CHECK OF WHETHER THE USER IN SESSION IS AN ADMIN
                UserSession.bypassAdminCheck()
                // Update the application as if the trainer accepted it
                user.trainerApplication!!.isApproved = true
                onBecomeTrainer()
            }
            else if (adminRejects.isChecked) {
                // BYPASS THE CHECK OF WHETHER THE USER IN SESSION IS AN ADMIN
                UserSession.bypassAdminCheck()
                // Update the application as if the trainer accepted it
                user.trainerApplication!!.isApproved = false
                user.trainerApplication!!.reasonOfDenial = "This is some reason the admin provided"
                onBecomeTrainer()
            }
            else {
                Toast.makeText(this@UserProfile, "Application pending",
                    Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun disableComplementarySwitch(switch: View) {
        if(switch == adminAccepts) {
            adminRejects.isChecked = false
        }
        else {
            adminAccepts.isChecked = false
        }
    }

    private fun setupNavigation() {
        this.drawerLayout = findViewById(R.id.drawerLayout)
        NavigationUtils.setupNavigation(this, drawerLayout, supportActionBar)
        //Setup BecomeTrainer button
        val buttonBecomeTrainer = findViewById<Button>(R.id.BecomeTrainer_button)
        // set on-click listener
        buttonBecomeTrainer.setOnClickListener {
            val intent = Intent(this, UploadDocumentsBoundary::class.java)
            startActivity(intent)   }
    }
}