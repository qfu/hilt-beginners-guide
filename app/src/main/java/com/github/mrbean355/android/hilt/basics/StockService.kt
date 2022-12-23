package com.github.mrbean355.android.hilt.basics

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface StockService {
    @GET("portfolio.json")
    suspend fun getPortfolio(): StockList
}

data class StockList(
    val stocks: List<Stock>,
)

data class Stock(
    val ticker: String,
    val name: String,
    val currency: String,
    val current_price_cents: Int,
    val quantity: Int?,
    val timestamp: Int,
)

