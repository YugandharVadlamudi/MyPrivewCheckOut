package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MapHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_host)
//        fragmentManager.beginTransaction().add(R.id.map_host,MapFrag()).commit()
//        supportFragmentManager.beginTransaction().add(R.id.map_host,MapFrag()).commit()
        fragmentManager.beginTransaction().add(R.id.map_host,MapFragment(),"").commit()
    }
}
