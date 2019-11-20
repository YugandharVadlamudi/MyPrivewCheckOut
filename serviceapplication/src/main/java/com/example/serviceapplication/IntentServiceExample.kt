package com.example.serviceapplication

import android.app.IntentService
import android.content.Intent
import android.util.Log

class IntentServiceExample : IntentService("HelloIntentService") {
    private val TAG = IntentServiceExample::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, ":OnCreate ");
    }

    override fun onHandleIntent(p0: Intent?) {
        Log.e(TAG, "onHandleIntent:${p0?.extras?.get("H")} ");
        try {
            for (i in 0..10) {
                Log.e(TAG, ":${i} ");
                Thread.sleep(8000)
            }
        } catch (e: InterruptedException) {
            // Restore interrupt status.
            Thread.currentThread().interrupt()
        }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, ":onStartCommand ");
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.e(TAG, ":onStart ");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, ":onDestroy ");
    }
}
/*
LifeCycle callback execution
    Oncarete->onStartCommand->onStart->OnHandleIntent->OnDestroy
    if we Try to call onemore IntentServie
    here service is already Created
    onStartCommand->onStart->onHandleIntnet->onDestory
 */
