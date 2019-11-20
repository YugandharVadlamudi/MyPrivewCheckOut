package com.example.oncreatefinish

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

/**
 * @author Tech.us
 * @class DemoApplication
 * @description Use of Class
 * @created on  6/16/2019
 * @copyright 2019 Tech.us
 * @since 1.0
 */
class DemoApplication:Application() {
    val TAG=DemoApplication::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate: ");
        this.registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks {
            override fun onActivityPaused(p0: Activity) {
                Log.e(TAG, ":onActivityPaused ");
            }

            override fun onActivityStarted(p0: Activity) {
                Log.e(TAG, ":onActivityStarted ");

            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.e(TAG, "onActivityDestroyed: ");
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.e(TAG, "onActivitySaveInstanceState: ");
            }

            override fun onActivityStopped(p0: Activity) {
                Log.e(TAG, "onActivityStopped: ");
            }

            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.e(TAG, "onActivityCreated: ");
            }

            override fun onActivityResumed(p0: Activity) {
                Log.e(TAG, "onActivityResumed: ");
            }
        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e(TAG, "onConfigurationChanged:${newConfig.orientation} ");
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.e(TAG, "onLowMemory: ");
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.e(TAG, "onTrimMemory: ");
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.e(TAG, "onTerminate: ");
    }
}