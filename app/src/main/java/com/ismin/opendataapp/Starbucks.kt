package com.ismin.opendataapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Starbucks(val city:String, @SerializedName("street_combined")  val street:String): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}