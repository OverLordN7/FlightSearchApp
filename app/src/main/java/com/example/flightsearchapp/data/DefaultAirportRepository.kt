package com.example.flightsearchapp.data

import kotlinx.coroutines.flow.Flow

class DefaultAirportRepository(private val airportDao: AirportDao): AirportRepository {
    override fun getAllAirports(): Flow<List<Airport>>  = airportDao.getAirports()

}