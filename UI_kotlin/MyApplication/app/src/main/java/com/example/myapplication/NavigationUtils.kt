package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

object NavigationUtils {

    fun setupNavigation(
        activity: Activity,
        drawerLayout: DrawerLayout,
        supportActionBar: ActionBar?
    ) {
        val actionBarToggle = ActionBarDrawerToggle(activity, drawerLayout, 0, 0)
        val navView = activity.findViewById<NavigationView>(R.id.navView)
        drawerLayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    activity.startActivity(Intent(activity, UserProfile::class.java))
                    true
                }
                R.id.ranking -> {
                    activity.startActivity(Intent(activity, Ranking::class.java))
                    true
                }
                R.id.nav_home -> {
                    // TODO: implement navigation to home
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}