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

class TrainersListBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainers_list_boundary)
        val actionBar = supportActionBar

        actionBar!!.title = "Trainers List"

        actionBar.setDisplayHomeAsUpEnabled(true)
        val listView = findViewById<ListView>(R.id.hours_listview)
        listView.adapter = MyCustomAdopter4(this)
    }

    inner class MyCustomAdopter4(context: Context): BaseAdapter() {
        private val mContext: Context
        private val names = arrayListOf<String>(
            "Trainer 1", "Trainer 2", "Trainer 3", "Trainer 4", "Trainer 5", "Trainer 6"
        )

        init {
            mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val trainerslist = layoutInflater.inflate(R.layout.trainers_list_item, viewGroup, false)
            val nametextView = trainerslist.findViewById<TextView>(R.id.trainer_name)
            nametextView.text = names.get(position)

            val report_btn = trainerslist.findViewById<Button>(R.id.check_trainer_btn)
            report_btn.text = "Check"
            report_btn.setOnClickListener { view ->
                val intent = Intent(this@TrainersListBoundary, TrainerProfileBoundary::class.java)
                startActivity(intent) }

            return trainerslist
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