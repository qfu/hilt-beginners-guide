package com.github.mrbean355.android.hilt.basics

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class BeerRepositoryImpl(
    private val beerService: BeerService,
    private val beerCache: BeerCache,
    private val dispatcher: CoroutineDispatcher
) {

    private val mutex = Mutex()

    constructor() : this(
        beerService = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(),
        beerCache = BeerCache,
        dispatcher = Dispatchers.IO
    )

    suspend fun getBeers(): List<Beer> = withContext(dispatcher) {
        mutex.withLock {
            beerCache.load()?.let {
                return@withContext it
            }
            val data = beerService.list().body()
                ?: return@withContext emptyList()
            beerCache.save(data)
            data
        }
    }
}