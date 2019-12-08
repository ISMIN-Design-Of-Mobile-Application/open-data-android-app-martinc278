package com.ismin.opendataapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.content.Intent



/**
 * Fragment pour la partie "App details" de l'application
 */
class AppDetailsFragment : Fragment() {
    private var listener: OnAppDetailsFragmentInteractionListener? = null
    private lateinit var rootView : View
    private var subject : String = "App Review"
    private var message : String = "\nEnvoyé depuis l'application! "
    private var recipient : String = "axelle.arnaud@orange.fr,martin-caron@outlook.com"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        rootView = inflater.inflate(R.layout.fragment_app_details, container, false)
        rootView.findViewById<Button>(R.id.buttonSendReview).setOnClickListener{sendEmail() }
        return rootView
    }


    private fun sendEmail() {
        val mIntent = Intent(Intent.ACTION_SEND)

        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Please choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            //Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
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
