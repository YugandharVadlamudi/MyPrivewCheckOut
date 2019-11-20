package com.example.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_single_top2.*
class SingleTop2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_top2)
        button4.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SingleTop3::class.java ))
        })
    }
    val TAG: String = SingleTop2::class.java.simpleName
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(TAG, ": onNewIntent");
    }
}
