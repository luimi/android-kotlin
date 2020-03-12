package com.lui2mi.android_kotlin_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import models.Module

class MainActivity : AppCompatActivity() {
    private lateinit var list: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val modules : List<Module> = mutableListOf(
            Module("REST",RESTActivity.newIntent(this))
        )

        list = findViewById(R.id.lv_modules)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, modules)
        list.setOnItemClickListener {parent, view, position, id ->
            startActivity(modules[position].intent)
        }
        list.adapter = adapter
    }
}
