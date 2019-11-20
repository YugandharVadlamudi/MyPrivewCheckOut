package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.custom_content.view.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        val infoWindow = InfoWindow(this)
        mMap.setInfoWindowAdapter(infoWindow)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        })
    }

    class InfoWindow(val context: Context) : GoogleMap.InfoWindowAdapter,View.OnTouchListener {
        override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
            when (view?.id) {
                R.id.radioButton->{
                    Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()
                }

            }
            return false
        }


        override fun getInfoContents(p0: Marker?): View {
            val view = (context as Activity).layoutInflater.inflate(R.layout.custom_content, null)
            val radio = view.findViewById<RadioButton>(R.id.radioButton)
            radio.text="hello"
            radio.setOnTouchListener(this)
            return view

        }

        override fun getInfoWindow(p0: Marker?): View? {
            return null
        }

    }

}
