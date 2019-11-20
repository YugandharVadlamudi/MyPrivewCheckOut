package com.example.kotlineverywear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
     var count: Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (c in 1..5) {
            count()

        }

    }

    fun count(): Unit {
        val textview = findViewById<TextView>(R.id.tv_check)
        val counstString = textview.text.toString()
        count = countString.toInt(countString)w
        count++
    }
}
