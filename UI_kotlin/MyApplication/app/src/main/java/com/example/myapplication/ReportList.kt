package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView



class ReportList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.report_list)

        val actionBar = supportActionBar

        actionBar!!.title = "Report List"

        actionBar.setDisplayHomeAsUpEnabled(true)
        val listView = findViewById<ListView>(R.id.report_listView)
        listView.adapter = MyCustomAdopter(this)
    }
    private class MyCustomAdopter(context: Context): BaseAdapter() {
        private val mContext: Context
        private val names = arrayListOf<String>(
            "Report 0", "Report 1", "Report 2", "Report 3"
        )
        init{
            mContext = context
        }
        override fun getView(position: Int, convertView: View?, viewGroup:  ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
            val nametextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nametextView.text = names.get(position)

            val report_btn = rowMain.findViewById<Button>(R.id.report_btn)
            report_btn.text = "See report $position"
            report_btn.setOnClickListener{}

            return rowMain

            //  val textView = TextView(mContext)
            // textView.text = "Here is"
            //  return textView
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
