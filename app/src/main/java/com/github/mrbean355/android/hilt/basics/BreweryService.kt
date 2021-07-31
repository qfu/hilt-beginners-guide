package com.github.mrbean355.android.hilt.basics

import retrofit2.Response
import retrofit2.http.GET

interface BeerService {

    @GET("beers?per_page=25")
    suspend fun list(): Response<List<Beer>>

}

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val image_url: String,
)