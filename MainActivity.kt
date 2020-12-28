package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var buttonNext: Button
    lateinit var buttonAdd:Button
    lateinit var searchBar:EditText
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNext = findViewById(R.id.buttonNext)
        buttonAdd = findViewById(R.id.buttonAdd)
        searchBar = findViewById(R.id.searchBar)
        listView = findViewById(R.id.listView)

        var friends = arrayListOf<String>()
        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends)
        buttonAdd.setOnClickListener{
            if(searchBar.text.toString().isNotEmpty()){
                friends.add(searchBar.text.toString())
                (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
                searchBar.text.clear()
            } else {
                Toast.makeText(applicationContext,"Please enter a name.", Toast.LENGTH_SHORT).show()
                searchBar.error = "Please enter a name."
                return@setOnClickListener
            }
        }
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext,"You have removed ${friends[i]}", Toast.LENGTH_SHORT).show()
            friends.remove(friends[i])
            (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
        }
    }
}