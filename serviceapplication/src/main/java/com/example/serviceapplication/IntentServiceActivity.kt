package com.example.serviceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class IntentServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)
    }

    override fun onStart() {
        super.onStart()
        startService(Intent(this,IntentServiceExample::class.java).putExtra("H","IntentService"))
        startService(Intent(this,IntentServiceExample::class.java).putExtra("H","IntentService2"))
    }
}
