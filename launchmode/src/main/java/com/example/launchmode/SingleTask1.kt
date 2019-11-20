package com.example.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_single_task1.*


class SingleTask1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task1)
        button8.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,SingleTask2::class.java))
        })
    }
val TAG=SingleTask1::class.java.simpleName
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(TAG, "onNewIntet ");
    }
}
