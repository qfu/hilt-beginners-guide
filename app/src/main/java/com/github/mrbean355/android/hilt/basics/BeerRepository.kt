package com.github.mrbean355.android.hilt.basics

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface BeerRepository {

    suspend fun getBeers(): List<Beer>

}

// Adding @Inject to a constructor tells Dagger to use that constructor when creating the class.
// All parameters of the constructor also need to be provided by Dagger.
class BeerRepositoryImpl @Inject constructor(
    private val beerService: BeerService,
    private val beerCache: BeerCache,
    private val dispatcher: CoroutineDispatcher,
    private val stockService: StockService,
) : BeerRepository {

    private val mutex = Mutex()

    override suspend fun getBeers(): List<Beer> = withContext(dispatcher) {
        mutex.withLock {
            beerCache.load()?.let {
                return@withContext it
            }
            val data = beerService.list().body()
                ?: return@withContext emptyList()
            beerCache.save(data)
            println(stockService.getPortfolio())
            data
        }
    }
}