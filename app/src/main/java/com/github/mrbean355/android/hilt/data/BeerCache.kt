package com.github.mrbean355.android.hilt.data

import com.github.mrbean355.android.hilt.service.Beer

object BeerCache {
    private var beers: List<Beer>? = null

    fun save(beers: List<Beer>) {
        this.beers = beers
    }

    fun load(): List<Beer>? = beers?.toList()

}