package com.example.serviceapplication.boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.*

/**
 * @author Tech.us
 * @class LocalBoundService
 * @description Use of Class
 * @created on  7/14/2019
 * @copyright 2019 Tech.us
 * @since 1.0
 */
class LocalBoundService : Service() {
    private var biner = BinderClass()

    private var mRandomNumber = Random()
    private var number = mRandomNumber.nextInt(100)
    private val TAG = LocalBoundService::class.java.simpleName

    override fun onBind(p0: Intent?): IBinder? {
        return biner
    }

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, ":onCreate ");
        for (c in 0..10) {
            Log.e(TAG, ":${c} ");
            Thread.sleep(1000 * 2)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, ":onStartCommand ");
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.e(TAG, ":onStart ");
        try {

        } catch (e: Exception) {
            Log.e(TAG, ":${e.message} ");
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, ":onDestory ");
    }

    inner class BinderClass : Binder() {
        fun getService(): LocalBoundService = this@LocalBoundService
        fun check(): Unit {
            Log.e(TAG, ":Check ");
        }

    }

    fun getNumber() = number

}