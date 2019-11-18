package com.ismin.opendataapp

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), AppDetailsFragment.OnAppDetailsFragmentInteractionListener,displayListStarbucksFragment.displayListStarbucksFragmentInteractionListener {

    private val starbucksTable: ArrayList<Starbucks> = arrayListOf();
    private lateinit var starbucksService: StarbucksService
    private var SERVER_BASE_URL: String = "https://data.opendatasoft.com/api/v2/"

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

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVER_BASE_URL)
            .build()

        starbucksService = retrofit.create<StarbucksService>(StarbucksService::class.java)

        getStarbucksFromServer()
        displayStarbucksList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun getStarbucksFromServer(){
        starbucksService.getStarbucks()
            .enqueue(object : Callback<List<Starbucks>> {
                override fun onResponse(
                    call: Call<List<Starbucks>>,
                    response: Response<List<Starbucks>>
                ) {
                    val allBottles = response.body()
                    starbucksTable.clear()
                    if(allBottles!=null) {
                        starbucksTable.addAll(allBottles)
                    }
                    displayStarbucksList()
                }

                override fun onFailure(call: Call<List<Starbucks>>, t: Throwable) {
                    // DO THINGS
                }
            })

    }

    fun displayStarbucksList(){
        val test: Starbucks = Starbucks("NYC", "5th ave")
        starbucksTable.add(test)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = displayListStarbucksFragment()

        val bundle = Bundle()
        bundle.putSerializable("starbucks",starbucksTable)
        fragment.arguments = bundle

        fragmentTransaction.replace(R.id.fragment_space, fragment)
        fragmentTransaction.commit()

    }

    fun displayAppDetails(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = AppDetailsFragment()

        fragmentTransaction.replace(R.id.fragment_space, fragment)
        fragmentTransaction.commit()
    }

    fun displayMap(){

    }
    /**
     * Pour les interfaces des fragments
     */
    override fun onAppDetailsFragmentInteraction(uri: Uri) {
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
