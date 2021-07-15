package com.github.mrbean355.android.hilt.data

import com.github.mrbean355.android.hilt.service.Beer
import com.github.mrbean355.android.hilt.service.BeerService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

class BeerRepository(
    private val beerService: BeerService,
    private val beerCache: BeerCache,
    private val dispatcher: CoroutineDispatcher
) {
    private val mutex = Mutex()

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