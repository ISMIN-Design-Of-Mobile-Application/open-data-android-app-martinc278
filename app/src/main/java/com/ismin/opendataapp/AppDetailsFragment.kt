package com.ismin.opendataapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Fragment pour la partie "App details" de l'application
 */
class AppDetailsFragment : Fragment() {
    private var listener: OnAppDetailsFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_app_details, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAppDetailsFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnAppDetailsFragmentInteractionListener {
        fun onAppDetailsFragmentInteraction(uri: Uri)
    }

}
