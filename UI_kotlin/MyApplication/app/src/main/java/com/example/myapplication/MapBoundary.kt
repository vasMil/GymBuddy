package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MapBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_boundary)
        supportActionBar?.apply {
            title = "Find Gym"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }

        // Set search event listener
        val searchBtn = findViewById<Button>(R.id.searchButton)
        searchBtn.setOnClickListener {
            handleSearch()
        }
    }

    private fun handleSearch() {
        // Get the info provided in textViews
        val addressView = findViewById<EditText>(R.id.addressEditText)
        val maxDistView = findViewById<EditText>(R.id.maxDistanceEditText)
        val geolocationService = GeolocationService()
        val gymService = GymService()
        val maxDistStr = maxDistView.text.toString()

        // If the max distance is not empty and not a number, its value is considered invalid
        if (!maxDistStr.isNumeric() && maxDistStr.isNotEmpty()) {
            Toast.makeText(this@MapBoundary,"Max distance should be a number!",
                Toast.LENGTH_SHORT).show()
            return;
        }

        // If an address is provided use geolocation to map the address provided to a lat, lng pair
        val address = addressView.text.toString()
        val addressCoords = geolocationService.addressToCoords(address)
        // if the return is null get current location and make a toast that you did not find the
        // address - return
        if(addressCoords == null) {
            Toast.makeText(this@MapBoundary,"Unable to locate address provided!",
                Toast.LENGTH_SHORT).show()
            previewGym()
            return;
        }
        // Update current screen with the data from GymService
        // due to the code simplicity consider current location may only be Plateia Georgiou
        else if(address != "Plateia Georgiou") {
            previewGym(gymService.getGymByLocation(addressCoords))
            return;
        }

        // At this point max distance is required so I may find gyms nearby
        // If max distance is empty toast an error and return
        if (maxDistView.text.toString() == "") {
            Toast.makeText(this@MapBoundary,"Max distance cannot be empty!",
                Toast.LENGTH_SHORT).show()
            return;
        }
        val maxDist = maxDistView.text.toString().toInt()
        if (maxDist < 0) {
            Toast.makeText(this@MapBoundary,"Max distance cannot be negative!",
                Toast.LENGTH_SHORT).show()
            return;
        }

        // Else find nearby gyms - intent to GymsInAreaBoundary

    }

    private fun previewGym(gym: Gym? = null) {
        val mapView = findViewById<ImageView>(R.id.mapView)

        // Add gym.image to the view, if null add the currentLocation
        if(gym == null) {
            mapView.setImageResource(R.drawable.geo_plateia_georgiou)
            hideKeyboard()
            return;
        }
        // Display image and accept button
        mapView.setImageResource(gym.googleImage)
        hideKeyboard()
    }

    private fun String.isNumeric(): Boolean {
        val numericRegex = Regex("-?\\+?[0-9]+")
        if(numericRegex.matches(this))
            return true
        return false
    }

    /* Utility function to hide the keyboard after the search */
    // Source: https://stackoverflow.com/questions/41790357/close-hide-the-android-soft-keyboard-with-kotlin
    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}