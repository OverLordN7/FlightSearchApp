package com.example.flightsearchapp.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
    //@Query("SELECT * from airport WHERE name LIKE \'%:query%\' OR iata_code= \':query\'")
    @Query("SELECT * from airport WHERE iata_code= :query OR name LIKE '%' || :query || '%' ")
    fun getAirportsSatisfied(query: String): Flow<List<Airport>>

    @Query("SELECT * from airport")
    fun getAirports(): Flow<List<Airport>>


}