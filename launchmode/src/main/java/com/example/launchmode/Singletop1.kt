package com.example.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_singletop1.*


class Singletop1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singletop1)
        button3.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SingleTop2::class.java ))
        })
    }
    val TAG: String = Singletop1::class.java.simpleName
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(TAG, ": onNewIntent");
    }
}
