package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow

class LeaderboardBoundary : AppCompatActivity() {
    lateinit var table: TableLayout
    lateinit var t1: TableRow



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        t1 = TableRow (this)
        setContentView(R.layout.activity_leaderboard_boundary)
    }
}