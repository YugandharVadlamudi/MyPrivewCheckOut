package com.example.loaderexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.loader.content.AsyncTaskLoader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    class LoaderExample(context: Context) : AsyncTaskLoader<Int>(context) {
        override fun loadInBackground(): Int? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
