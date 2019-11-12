package com.ismin.opendataapp

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AppDetailsFragment.OnAppDetailsFragmentInteractionListener{

    private val starbucksTable: ArrayList<Starbucks> = arrayListOf();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayStarbucksList(); //On commence par afficher la liste des starbucks dans l'applicatipon

        this.findViewById<Button>(R.id.a_starbucks_list).setOnClickListener{
            displayStarbucksList()
        }
        this.findViewById<Button>(R.id.a_app_details).setOnClickListener{
            displayAppDetails()
        }
        this.findViewById<Button>(R.id.a_map).setOnClickListener{
            displayMap()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun displayStarbucksList(){

    }

    fun displayAppDetails(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = AppDetailsFragment()

        fragmentTransaction.replace(R.id.fragment_space, fragment)
        fragmentTransaction.commit()
    }

    fun displayMap(){

    }

// Pour les interfaces des fragments
    override fun onAppDetailsFragmentInteraction(uri: Uri) {
    }
}
