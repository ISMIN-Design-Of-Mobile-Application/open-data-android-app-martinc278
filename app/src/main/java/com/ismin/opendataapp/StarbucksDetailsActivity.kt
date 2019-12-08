package com.ismin.opendataapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_starbucks_details.view.*
import kotlin.random.Random.Default.nextInt

const val STARBUCK_DETAIL_EXTRA_KEY = "1"
val imgSrc : IntArray = intArrayOf(R.drawable.starbucks1, R.drawable.starbucks2, R.drawable.starbucks2, R.drawable.starbucks3, R.drawable.starbucks4, R.drawable.starbucks5, R.drawable.starbucks6, R.drawable.starbucks7, R.drawable.starbucks8, R.drawable.starbucks9, R.drawable.starbucks10)

class StarbucksDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starbucks_details)

        val starbucksToDisplay: Starbucks = getIntent().getSerializableExtra(STARBUCK_DETAIL_EXTRA_KEY) as Starbucks
        findViewById<TextView>(R.id.a_starbucks_details_cityToChange).text = starbucksToDisplay.city
        findViewById<TextView>(R.id.a_starbucks_details_streetToChange).text = starbucksToDisplay.street
        findViewById<TextView>(R.id.a_starbucks_details_latitudeToChange).text = starbucksToDisplay.latitude.toString()
        findViewById<TextView>(R.id.a_starbucks_details_longitudeToChange).text = starbucksToDisplay.longitude.toString()
        findViewById<ImageView>(R.id.a_img_starbucks).setImageResource(imgSrc.get(nextInt(1,10)))
    }

    fun stopActivityAndReturnResult(view : View) {
        val returnIntent = Intent()
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}
