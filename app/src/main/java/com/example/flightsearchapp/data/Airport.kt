package com.example.flightsearchapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("airport")
data class Airport(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "iata_code")
    val code: String,
    @ColumnInfo(name = "passengers")
    val passengers: Int,
)