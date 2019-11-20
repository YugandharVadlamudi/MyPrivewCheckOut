package com.example.serviceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var serviceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        serviceIntent = Intent(this, ServiceExample::class.java)
        serviceIntent.putExtra("H", "h")
        startService(serviceIntent)
        bt_intentservice.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startActivity(Intent(this@MainActivity,IntentServiceActivity::class.java))
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val serviceIntent = Intent(this, ServiceExample::class.java)
        serviceIntent.putExtra("H", "c")
        startService(serviceIntent)
    }

    override fun onPause() {
        super.onPause()
        stopService(Intent(this, ServiceExample::class.java))
        stopService(serviceIntent)
    }

}
