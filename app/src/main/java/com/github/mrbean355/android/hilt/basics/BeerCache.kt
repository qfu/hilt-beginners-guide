package com.github.mrbean355.android.hilt.basics

object BeerCache {
    private var beers: List<Beer>? = null

    fun save(beers: List<Beer>) {
        this.beers = beers
    }

    fun load(): List<Beer>? = beers?.toList()

}