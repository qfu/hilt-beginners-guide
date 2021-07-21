package com.github.mrbean355.android.hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mrbean355.android.hilt.data.BeerCache
import com.github.mrbean355.android.hilt.data.BeerRepositoryImpl
import com.github.mrbean355.android.hilt.service.Beer
import com.github.mrbean355.android.hilt.service.BeerService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainViewModel : ViewModel() {
    private val repo = BeerRepositoryImpl(createService(), BeerCache, Dispatchers.IO)
    private val _beers = MutableLiveData<List<Beer>>()

    val beers: LiveData<List<Beer>> get() = _beers

    fun initialise() {
        viewModelScope.launch {
            _beers.value = repo.getBeers().sortedBy { it.name }
        }
    }

    private fun createService(): BeerService {
        return Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}