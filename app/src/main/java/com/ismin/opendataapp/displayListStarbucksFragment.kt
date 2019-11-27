package com.ismin.opendataapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [displayListStarbucksFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */

const val STARBUCKS_DETAILS__REQUEST_CODE = "1"

class displayListStarbucksFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var listener: displayListStarbucksFragmentInteractionListener? = null
    private var starbucksTable: ArrayList<Starbucks> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview= inflater.inflate(R.layout.fragment_display_list_starbucks, container, false)
        starbucksTable = arguments!!.getSerializable("starbucks") as ArrayList<Starbucks>

        recyclerView = rootview.findViewById<RecyclerView>(R.id.a_rcv_starbucks)
        val adapter = StarbucksAdapter(starbucksTable, AdapterView.OnItemClickListener { parent, view, position, id ->
            starbucksDetails(position)
            //recyclerView.adapter?.notifyDataSetChanged()
        })
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        return rootview
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is displayListStarbucksFragmentInteractionListener) {
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
    interface displayListStarbucksFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    fun starbucksDetails(position: Int){
        val intent = Intent(this.context, StarbucksDetailsActivity::class.java)
        intent.putExtra(STARBUCKS_DETAILS__REQUEST_CODE, starbucksTable.get(position))
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}
