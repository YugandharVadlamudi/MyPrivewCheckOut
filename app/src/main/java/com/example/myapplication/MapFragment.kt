package com.example.myapplication

import android.content.Intent
import android.graphics.Point
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.AbsoluteLayout
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.Projection
import com.google.android.gms.maps.model.*

import java.util.HashMap

import android.view.View.*
import android.view.ViewGroup.LayoutParams.MATCH_PARENT

class MapFragment : com.google.android.gms.maps.MapFragment(), GoogleMap.OnMapClickListener,
    GoogleMap.OnMarkerClickListener, OnClickListener, OnMapReadyCallback {

    private var spots: MutableMap<Marker, Spot>? = null

    //точка на карте, соответственно перемещению которой перемещается всплывающее окно
    private var trackedPosition: LatLng? = null

    //Handler, запускающий обновление окна с заданным интервалом
    private var handler: Handler?=null
    //Runnable, который обновляет положение окна
    private var positionUpdaterRunnable: Runnable? = null

    //смещения всплывающего окна, позволяющее
    //скорректировать его положение относительно маркера
    private var popupXOffset: Int = 0
    private var popupYOffset: Int = 0
    //высота маркера
    private var markerHeight: Int = 0
    private var overlayLayoutParams: AbsoluteLayout.LayoutParams? = null

    //слушатель, который будет обновлять смещения
    private var infoWindowLayoutListener: ViewTreeObserver.OnGlobalLayoutListener? = null

    //контейнер всплывающего окна
    private var infoWindowContainer: View? = null
    private var textView: TextView? = null
    private var button: TextView? = null
    private lateinit var map: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        spots = HashMap()
        markerHeight = resources.getDrawable(R.drawable.pin).intrinsicHeight
    }

    override fun getMapAsync(onMapReadyCallback: OnMapReadyCallback) {
        super.getMapAsync(onMapReadyCallback)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle): View? {
        val rootView = inflater.inflate(R.layout.fragment, null)

        val containerMap = rootView.findViewById<View>(R.id.container_map) as FrameLayout
        val mapView = super.onCreateView(inflater, container, savedInstanceState)
        containerMap.addView(mapView, FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))
        getMapAsync(this)

        //        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        /* map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(48.35, 31.16), 5.5f));
        map.getUiSettings().setRotateGesturesEnabled(false);
        map.setOnMapClickListener(this);
        map.setOnMarkerClickListener(this);*/

        //        map.clear();
        spots!!.clear()
        /*BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.pin);
        for (Spot spot : SPOTS_ARRAY) {
            Marker marker = map.addMarker(new MarkerOptions()
                    .position(spot.getPosition())
                    .title("Title")
                    .snippet("Subtitle")
                    .icon(icon));
            spots.put(marker, spot);
        }
*/
        infoWindowContainer = rootView.findViewById(R.id.container_popup)
        //подписываемся на изменения размеров всплывающего окна
        infoWindowLayoutListener = InfoWindowLayoutListener()
        infoWindowContainer!!.viewTreeObserver.addOnGlobalLayoutListener(infoWindowLayoutListener)
        overlayLayoutParams = infoWindowContainer!!.layoutParams as AbsoluteLayout.LayoutParams

        textView = infoWindowContainer!!.findViewById<View>(R.id.textview_title) as TextView
        button = infoWindowContainer!!.findViewById<View>(R.id.button_view_article) as TextView
        val progressBar = infoWindowContainer!!.findViewById<View>(R.id.pb_map_check) as ProgressBar
        progressBar.setOnClickListener(this)
        button!!.setOnClickListener(this)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //очистка
        handler = Handler(Looper.getMainLooper())
        positionUpdaterRunnable = PositionUpdaterRunnable()
        handler!!.post(positionUpdaterRunnable!!)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        infoWindowContainer!!.viewTreeObserver.removeGlobalOnLayoutListener(infoWindowLayoutListener)
        handler!!.removeCallbacks(positionUpdaterRunnable!!)
        handler = null
    }

    override fun onClick(v: View) {
        val name = v.tag as String
        startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com/search?q=$name")))
    }

    override fun onMapClick(latLng: LatLng) {
        infoWindowContainer!!.visibility = INVISIBLE
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        //        map = getMap();
        val projection = map.projection
        trackedPosition = marker.position
        val trackedPoint = projection.toScreenLocation(trackedPosition)
        trackedPoint.y -= popupYOffset / 2
        val newCameraLocation = projection.fromScreenLocation(trackedPoint)
        map.animateCamera(CameraUpdateFactory.newLatLng(newCameraLocation), ANIMATION_DURATION, null)

        val spot = spots!![marker]
        textView!!.text = spot?.getName()
        button!!.tag = spot?.getName()

        infoWindowContainer!!.visibility = VISIBLE

        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(48.35, 31.16), 5.5f))
        map.uiSettings.isRotateGesturesEnabled = false
        map.setOnMapClickListener(this)
        map.setOnMarkerClickListener(this)
        val icon = BitmapDescriptorFactory.fromResource(R.drawable.pin)
        for (spot in SPOTS_ARRAY) {
            val marker = map.addMarker(
                MarkerOptions()
                    .position(spot.position)
                    .title("Title")
                    .snippet("Subtitle")
                    .icon(icon)
            )
            spots!![marker] = spot
        }

    }

    private inner class InfoWindowLayoutListener : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            //размеры окна изменились, обновляем смещения
            popupXOffset = infoWindowContainer!!.width / 2
            popupYOffset = infoWindowContainer!!.height
        }
    }

    private inner class PositionUpdaterRunnable : Runnable {
        private var lastXPosition = Integer.MIN_VALUE
        private var lastYPosition = Integer.MIN_VALUE

        override fun run() {
            //помещаем в очередь следующий цикл обновления
            handler!!.postDelayed(this, POPUP_POSITION_REFRESH_INTERVAL.toLong())

            //если всплывающее окно скрыто, ничего не делаем
            if (trackedPosition != null && infoWindowContainer!!.visibility == VISIBLE) {
                val targetPosition = map.projection.toScreenLocation(trackedPosition)

                //если положение окна не изменилось, ничего не делаем
                if (lastXPosition != targetPosition.x || lastYPosition != targetPosition.y) {
                    //обновляем положение
                    overlayLayoutParams!!.x = targetPosition.x - popupXOffset
                    overlayLayoutParams!!.y = targetPosition.y - popupYOffset - markerHeight - 30
                    infoWindowContainer!!.layoutParams = overlayLayoutParams

                    //запоминаем текущие координаты
                    lastXPosition = targetPosition.x
                    lastYPosition = targetPosition.y
                }
            }
        }
    }

    companion object {

        private val SPOTS_ARRAY = arrayOf(
            Spot("Киев", LatLng(50.4546600, 30.5238000)),
            Spot("Одесса", LatLng(46.4774700, 30.7326200)),
            Spot("Харьков", LatLng(50.0000000, 36.2500000)),
            Spot("Львов", LatLng(49.8382600, 24.0232400)),
            Spot("Донецк", LatLng(48.0000000, 37.8000000))
        )

        //интервал обновления положения всплывающего окна.
        //для плавности необходимо 60 fps, то есть 1000 ms / 60 = 16 ms между обновлениями.
        private val POPUP_POSITION_REFRESH_INTERVAL = 16
        //длительность анимации перемещения карты
        private val ANIMATION_DURATION = 500
    }
}
