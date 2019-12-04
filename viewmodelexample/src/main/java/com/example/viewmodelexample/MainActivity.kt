package com.example.viewmodelexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewmodel = ViewModelProviders.of(this).get(ViewModelexample::class.java)
        Log.e(TAG, ": ${viewmodel.getList()}")

    }
}
