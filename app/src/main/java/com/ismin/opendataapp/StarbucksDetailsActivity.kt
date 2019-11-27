package com.ismin.opendataapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_starbucks_details.view.*

const val STARBUCK_DETAIL_EXTRA_KEY = "1"

class StarbucksDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starbucks_details)

        val starbucksToDisplay: Starbucks = getIntent().getSerializableExtra(STARBUCK_DETAIL_EXTRA_KEY) as Starbucks
        findViewById<TextView>(R.id.a_starbucks_details_cityToChange).text = starbucksToDisplay.city
        findViewById<TextView>(R.id.a_starbucks_details_streetToChange).text = starbucksToDisplay.street
    }

    fun stopActivityAndReturnResult(view : View) {
        val returnIntent = Intent()
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}
