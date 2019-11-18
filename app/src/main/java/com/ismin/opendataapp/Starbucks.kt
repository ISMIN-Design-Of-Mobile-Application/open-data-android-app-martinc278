package com.ismin.opendataapp

import com.google.gson.annotations.SerializedName

data class Starbucks(val city:String, @SerializedName("street_combined")  val street:String) {
}