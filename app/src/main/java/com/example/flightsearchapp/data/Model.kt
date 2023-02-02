package com.example.flightsearchapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Record(
    val id: String,
    val airportIndex: String,
    val airportFlightRecord: String,
)




@Entity("favorite")
data class Favorite(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "departure_code")
    val departure: String,
    @ColumnInfo(name = "destination_code")
    val destination: String,
)
