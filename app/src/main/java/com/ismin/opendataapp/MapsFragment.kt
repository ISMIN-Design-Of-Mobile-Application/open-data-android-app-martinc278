package com.ismin.opendataapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MapsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */

class MapsFragment : Fragment(), OnMapReadyCallback {

    private var starbucksTable: ArrayList<Starbucks> = arrayListOf()
    private var listener: MapsFragmentInteractionListener? = null
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview= inflater.inflate(R.layout.fragment_maps, container, false)
        starbucksTable = arguments!!.getSerializable("starbucks") as ArrayList<Starbucks>

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return rootview
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //mMap.addMarker(MarkerOptions().position(LatLng(starbucksTable.get(0).latitude, starbucksTable.get(0).longitude)))

        starbucksTable.forEach {
            val starbucks = LatLng(it.latitude, it.longitude)
            mMap.addMarker(MarkerOptions().position(starbucks))
        }

        val gardanne = LatLng(43.45, 5.4667)
        mMap.addMarker(MarkerOptions().position(gardanne).title("Mines St Etienne"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gardanne))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MapsFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface MapsFragmentInteractionListener {
        // TODO: Update argument type and name
        fun mapsInteraction()
    }

}
