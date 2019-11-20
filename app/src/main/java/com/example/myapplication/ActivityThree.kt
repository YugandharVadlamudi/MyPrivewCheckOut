package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_three.*
import kotlinx.android.synthetic.main.activity_two.*

class ActivityThree : AppCompatActivity() {
    val TAG:String=ActivityThree::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        Log.e(TAG, ": onCreate");
        button4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(baseContext, ActivityOne::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }
        })


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
