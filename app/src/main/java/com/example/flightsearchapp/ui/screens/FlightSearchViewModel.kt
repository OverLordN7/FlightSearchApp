package com.example.flightsearchapp.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.FlightSearchApplication
import com.example.flightsearchapp.data.Airport
import com.example.flightsearchapp.data.AirportDao
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch


const val TAGVIEWMODEL = "ViewModel"
class AirportViewModel(private val airportDao: AirportDao): ViewModel(){

    private val _searchResult = MutableStateFlow("")
    val searchResult: StateFlow<String> = _searchResult

    init {
        viewModelScope.launch {
            @OptIn(FlowPreview::class)
            _searchResult.debounce(1000).collect(::getSearchResult)
        }
    }

    fun updateSearchResult(search: String){
        _searchResult.value = search
    }

    override fun onCleared() {
        super.onCleared()
        getSearchResult(_searchResult.value)
    }

    private fun getSearchResult(search: String){
        //Call DB
        Log.d(TAGVIEWMODEL,"The search is: ${searchResult.value}")
    }

    fun getAirports():Flow<List<Airport>> = airportDao.getAirports()

    fun getAirportsSatisfied(query: String): Flow<List<Airport>> = airportDao.getAirportsSatisfied(query)

    companion object{
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as FlightSearchApplication
                AirportViewModel(application.database.airportDao())
            }
        }
    }
}