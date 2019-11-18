package com.ismin.opendataapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StarbucksService {
    @GET("opendatasoft/datasets/all-starbucks-locations-in-the-world%40public-us/exports/json")
    fun getStarbucks(): Call<List<Starbucks>>
}