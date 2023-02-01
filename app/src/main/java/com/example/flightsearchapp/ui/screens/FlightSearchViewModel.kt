package com.example.flightsearchapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.FlightSearchApplication
import com.example.flightsearchapp.data.Airport
import com.example.flightsearchapp.data.AirportDao
import kotlinx.coroutines.flow.Flow

class AirportViewModel(private val airportDao: AirportDao): ViewModel(){

    fun getAirports():Flow<List<Airport>> = airportDao.getAirports()

    companion object{
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as FlightSearchApplication
                AirportViewModel(application.database.airportDao())
            }
        }
    }
}