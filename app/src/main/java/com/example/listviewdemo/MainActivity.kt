package com.example.listviewdemo

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)

        listView.adapter = MyCustomerAdapter(this) // some kind of adapter
    }

    private class MyCustomerAdapter(context: Context) : BaseAdapter() {
        private val myContext: Context = context
        private val names = arrayListOf<String>(
            "Donald Trump", "Steve Jobs", "Tim Cook", "Barack Obama", "Mark Zuckerberg",
            "Donald Trump", "Steve Jobs", "Tim Cook", "Barack Obama", "Mark Zuckerberg",
            "Donald Trump", "Steve Jobs", "Tim Cook", "Barack Obama", "Mark Zuckerberg"
        )
        override fun getCount(): Int {
            return names.size
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowMain: View
            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(myContext)
                rowMain = layoutInflater.inflate(R.layout.row_main, parent, false)

                Log.d("Main", "calling findViewById, which is expensive")
                val viewHolder = ViewHolder(rowMain.name_textview, rowMain.position_textview)
                rowMain.tag = viewHolder
            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder

            viewHolder.nameTextView.text = names[position]

            viewHolder.positionTextView.text = "Row Number: $position"

            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)

    }
}