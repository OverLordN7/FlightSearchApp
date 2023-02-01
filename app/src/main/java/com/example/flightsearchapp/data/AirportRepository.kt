package com.example.flightsearchapp.data

import kotlinx.coroutines.flow.Flow

interface AirportRepository {

    fun getAllAirports(): Flow<List<Airport>>
}