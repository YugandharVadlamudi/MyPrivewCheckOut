package com.example.serviceapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * @author Tech.us
 * @class ServiceExample
 * @description Use of Class
 * @created on  6/30/2019
 * @copyright 2019 Tech.us
 * @since 1.0
 */
class ServiceExample : Service() {
    val TAG = ServiceExample::class.java.simpleName
     var startId:Int=0
    override fun onBind(p0: Intent?): IBinder? {
        Log.e(TAG, ":onBind ");
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, ":onCreate ");
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        this.startId=startId
        Log.e(TAG, ":onStarte ${intent?.getStringExtra("H")}");
        try {
            Thread.sleep(8000)
            stopSelf(startId)
        } catch (e: InterruptedException) {
            // Restore interrupt status.
            Thread.currentThread().interrupt()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, ":onDestroy ");
        stopSelf(startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, ":onStartCommand ");
        Log.e(TAG, ":${intent?.extras?.getString("H")} ");
        return super.onStartCommand(intent, flags, startId)
    }

}
/*
if we have time for execution for starting it will also execute one by one
 */