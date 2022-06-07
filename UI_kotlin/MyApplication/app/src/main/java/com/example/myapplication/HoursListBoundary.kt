package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class HoursListBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hours_list_boundary)
        val actionBar = supportActionBar

        actionBar!!.title = "Hours List"

        actionBar.setDisplayHomeAsUpEnabled(true)
        val listView = findViewById<ListView>(R.id.hours_listview)
        listView.adapter = MyCustomAdopter3(this)
    }

    inner class MyCustomAdopter3(context: Context): BaseAdapter() {
        private val mContext: Context
        private val names = arrayListOf<String>(
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
        )

        init {
            mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val hourslist = layoutInflater.inflate(R.layout.hours_list_item, viewGroup, false)
            val nametextView = hourslist.findViewById<TextView>(R.id.hour)
            nametextView.text = names.get(position)

            val report_btn = hourslist.findViewById<Button>(R.id.pick_hour_btn)
            report_btn.text = "See report $position"
            report_btn.setOnClickListener { view ->
                val intent = Intent(this@HoursListBoundary, TrainersListBoundary::class.java)
                startActivity(intent) }

            return hourslist
        }

        override fun getItem(position: Int): Any {
            return "TEst"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return names.size
        }
    }
}