package com.example.oncreatefinish

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * If we keep finish in oncreate it will finish the activity
 */
class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
     var savedInsnceState: Bundle?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInsnceState = savedInstanceState
//finish()
        Log.e(TAG, ":OnCreate ");
    }


    override fun onStart() {
        super.onStart()
//        setContentView(R.layout.activity_main)
        Log.e(TAG, ":onStart ");
        bt_mainactivity_secoundactivity.setOnClickListener {
            startActivityForResult(Intent(baseContext,Main2Activity::class.java),10 )
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, ":onresume ");

    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_main)
        Log.e(TAG, "onpuase: ");

    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ");
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editText",et_check.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        et_check.setText(savedInstanceState.getString("editText"))

        Log.e(TAG, "onRestoreInstanceState: ${savedInstanceState.getString("editText")}");
        Log.e(TAG, "onRestoreInstanceState: ${savedInsnceState?.getString("editText")}");

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e(TAG, "onActivityResult: ");
    }
    /**
     * When start an acitivty for result then mainactivity life cycle is
     * onActivityRusult->onRestart()->Sart()->onResume() will call back
     * Here MainActivity will pause after secound activity then it will call onstop of first
     * activivity    
     */
}

