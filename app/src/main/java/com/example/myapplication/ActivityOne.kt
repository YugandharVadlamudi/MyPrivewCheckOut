package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_one.*

/**
 * A program for  explain intent example with Clear Top
 */
class ActivityOne : AppCompatActivity() {
val TAG:String=ActivityOne::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        Log.e(TAG, ": oncreate");
        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(baseContext,ActivityTwo::class.java))
            }
        })
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(TAG, ": onNewItnet");
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, ": onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, ": onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, ": onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, ": onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, ": onDestroy");
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, ": onRestart");
    }
}
