package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class GymsInAreaBoundary : AppCompatActivity() {
    private lateinit var gymsNearby: Array<Gym>
    private var idx = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gyms_in_area_boundary)
        supportActionBar?.apply {
            title = "Select Nearby Gym"
            setBackgroundDrawable(ColorDrawable(Color.parseColor("#F16D22")))
        }
        gymsNearby = intent.getSerializableExtra("gyms") as Array<Gym>

        val nestedViewLL = findViewById<LinearLayout>(R.id.gymsView)

        // Create a button for each gym
        gymsNearby.forEach { gym ->
            val btn = Button(this)
            btn.setTextAppearance(R.style.nearbyGymButtonStyle)
            btn.text = "${gym.name}, Rating: ${if (gym.rating == -1) "Unavailable" else gym.rating.toString()}"
            btn.isAllCaps = false
            btn.id = idx++
            btn.setOnClickListener {
                handleGymChoice(btn.id)
            }
            nestedViewLL.addView(btn)
        }
    }

    private fun handleGymChoice(gymIndex: Int) {
        val gym = gymsNearby[gymIndex]
        val intentMap = Intent(this, HoursListBoundary::class.java)
        intentMap.putExtra("gym", gym)
        startActivity(intentMap)
    }
}