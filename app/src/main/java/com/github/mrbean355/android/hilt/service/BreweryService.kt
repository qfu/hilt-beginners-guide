package com.github.mrbean355.android.hilt.service

import retrofit2.Response
import retrofit2.http.GET

interface BeerService {

    @GET("beers?per_page=25")
    suspend fun list(): Response<List<Beer>>

}