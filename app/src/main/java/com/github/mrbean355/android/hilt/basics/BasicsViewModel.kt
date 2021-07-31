package com.github.mrbean355.android.hilt.basics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BasicsViewModel(
    private val repo: BeerRepositoryImpl
) : ViewModel() {

    private val _beers = MutableLiveData<List<Beer>>()

    val beers: LiveData<List<Beer>> get() = _beers

    @Suppress("unused") // called by ViewModelProvider
    constructor() : this(BeerRepositoryImpl())

    fun initialise() {
        viewModelScope.launch {
            _beers.value = repo.getBeers().sortedBy { it.name }
        }
    }
}