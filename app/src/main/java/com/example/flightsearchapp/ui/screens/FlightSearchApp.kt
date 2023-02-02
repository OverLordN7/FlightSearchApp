package com.example.flightsearchapp.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearchapp.data.Airport


const val TAG = "FlightSearchApp"


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FlightSearchApp(
    modifier: Modifier = Modifier,
    viewModel: AirportViewModel = viewModel(factory = AirportViewModel.factory)
){

    val airports by viewModel.getAirports().collectAsState(emptyList())

//    for (airport in airports){
//        Log.d(TAG,"name: ${airport.name} and iata_code: ${airport.code}")
//    }

    Scaffold(modifier = Modifier.padding(8.dp)) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(8.dp),
        ) {
            SearchRecord()
            ListOfAirports(airports = airports)

        }


    }

}

@Composable
fun ListOfAirports(airports: List<Airport>){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(8.dp),
    ) {

        items(airports){item: Airport ->
            RecordCard(airport = item)
        }
    }
}

@Composable
fun SearchRecord(modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        var record by remember {
            mutableStateOf("")
        }
        TextField(
            value = record,
            onValueChange ={record = it},
            placeholder = { Text(text = "Enter flight record") },
            singleLine = true,
        )
    }
}


@Composable
fun RecordCard(airport: Airport,modifier: Modifier = Modifier){
    Card(
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
            ) {
            Text(
                text = "${airport.code}",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "${airport.name}")
        }
    }
}


@Preview
@Composable
fun DefaultPreview(){
    FlightSearchApp()
}