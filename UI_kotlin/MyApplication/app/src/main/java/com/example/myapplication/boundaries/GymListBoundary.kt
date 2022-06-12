package com.example.myapplication.boundaries

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
import com.example.myapplication.R

//import com.example.myapplication.ReportList.MyCustomAdopter

class GymListBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_list_boundary)

        val actionBar = supportActionBar

        actionBar!!.title = "Gym List"

        actionBar.setDisplayHomeAsUpEnabled(true)
        val listView = findViewById<ListView>(R.id.gym_listView)
        listView.adapter = MyCustomAdopter2(this)

    }

    inner class MyCustomAdopter2(context: Context): BaseAdapter() {
        private val mContext: Context
        private val names = arrayListOf<String>(
            "Icon", "MVP", "Patraiko", "Fintess Mall", "Studio 6"
        )
        private var ind = 0

        init {
            mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val gymlist = layoutInflater.inflate(R.layout.gym_list_item, viewGroup, false)
            val nametextView = gymlist.findViewById<TextView>(R.id.name_textView)

            val gymName = gymlist.findViewById<TextView>(R.id.gym_name)
            gymName.text = names[ind++]
            val report_btn = gymlist.findViewById<Button>(R.id.pick_gym_btn)
            report_btn.text = "Pick"
            report_btn.setOnClickListener { view ->
                val intent = Intent(this@GymListBoundary, HoursListBoundary::class.java)
                startActivity(intent) }

            return gymlist
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
