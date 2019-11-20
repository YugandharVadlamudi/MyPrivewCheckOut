package com.example.serviceapplication.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.serviceapplication.R
import kotlinx.android.synthetic.main.activity_bound_service.*


/**
 * @author Tech.us
 * @class BoundServiceExampleActivity
 * @description Use of Class
 * @created on  7/14/2019
 * @copyright 2019 Tech.us
 * @since 1.0
 */
class BoundServiceExampleActivity : AppCompatActivity() {
    private val TAG = BoundServiceExampleActivity::class.java.simpleName
    private lateinit var localBounService: LocalBoundService
    private lateinit var bounServicebinder: LocalBoundService.BinderClass
    private var connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.e(TAG, "onServiceDisconnected: ");
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            bounServicebinder = p1 as LocalBoundService.BinderClass
            localBounService = bounServicebinder.getService()

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_service)
    }

    override fun onStart() {
        super.onStart()
         Intent(this, LocalBoundService::class.java).also {
            bindService(it, connection, Context.BIND_AUTO_CREATE )
        }

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.e(TAG, ":${localBounService.getNumber()} ");
            }
        })
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
        unbindService(connection)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }



}