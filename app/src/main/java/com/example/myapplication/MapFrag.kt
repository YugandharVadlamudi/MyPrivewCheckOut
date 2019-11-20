package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MapFrag.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MapFrag.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MapFrag : com.google.android.gms.maps.MapFragment(),GoogleMap.OnMapClickListener,GoogleMap.OnMarkerClickListener,OnMapReadyCallback {
    override fun onMapClick(p0: LatLng?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMapAsync(p0: OnMapReadyCallback?) {
        super.getMapAsync(p0)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }
    override fun onCreate(p0: Bundle?) {
        super.onCreate(p0)
    }

    override fun onCreateView(p0: LayoutInflater, p1: ViewGroup?, p2: Bundle?): View? {
        val customView=p0?.inflate(R.layout.custom_content,null)
        getMapAsync(this)
        return customView
//        return super.onCreateView(p0, p1, p2)
    }

    /*override fun onCreateView(inflater: LayoutInflater?, viewgroup: ViewGroup?, bundle: Bundle?): View? {
        val customView=inflater?.inflate(R.layout.custom_content,null)
        return customView
    }*/

    override fun onActivityCreated(p0: Bundle?) {
        super.onActivityCreated(p0)
    }

    /*override fun onStart() {
        super.onStart()
    }*/

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }
}
