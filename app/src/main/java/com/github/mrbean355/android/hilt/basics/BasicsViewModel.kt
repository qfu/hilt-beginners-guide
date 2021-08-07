package com.github.mrbean355.android.hilt.basics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// Use @HiltViewModel on view models that Hilt should inject.
// Note that the constructor must be annotated with @Inject.
// View models do NOT need to be installed into a @Module.
@HiltViewModel
class BasicsViewModel @Inject constructor(
    private val repo: BeerRepository
) : ViewModel() {

    private val _beers = MutableLiveData<List<Beer>>()

    val beers: LiveData<List<Beer>> get() = _beers

    fun initialise() {
        viewModelScope.launch {
            _beers.value = repo.getBeers().sortedBy { it.name }
        }
    }
}